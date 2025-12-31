package com.amalitech.nosqlblog.service.impl;

import com.amalitech.nosqlblog.cache.Cache;
import com.amalitech.nosqlblog.cache.LruCache;
import com.amalitech.nosqlblog.dao.impl.PostDAOImpl;
import com.amalitech.nosqlblog.model.Post;
import com.amalitech.nosqlblog.service.PostService;
import com.amalitech.nosqlblog.utils.MongoDBConnection;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.util.List;
import java.util.Optional;

public class PostServiceImpl implements PostService {
    MongoClient client = MongoDBConnection.connect();
    private final Cache<String, Post> postCache;

    public PostServiceImpl() {
        this.postCache = new LruCache<>(50);
    }

    @Override
    public Post create(Post post) {
        try{
            MongoDatabase db = client.getDatabase("java-demo");
            PostDAOImpl postDAO = new PostDAOImpl(db);
            Post saved = postDAO.save(post);
            postCache.put(saved.getId(), saved);
            return saved;
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize PostServiceImpl", e);
        } finally {
            client.close(); // close only after all DB work is done
        }
    }

    @Override
    public Post update(Post post) {
        try{
            MongoDatabase db = client.getDatabase("java-demo");
            PostDAOImpl postDAO = new PostDAOImpl(db);
            if(postDAO.update(post)){
                postCache.put(post.getId(), post);
                return post;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize PostServiceImpl", e);
        } finally {
            client.close(); // close only after all DB work is done
        }
    }

    @Override
    public boolean delete(String postId) {
        try{
            MongoDatabase db = client.getDatabase("java-demo");
            PostDAOImpl postDAO = new PostDAOImpl(db);
            if(postDAO.deleteById(postId)){
                postCache.remove(postId);
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize PostServiceImpl", e);
        } finally {
            client.close(); // close only after all DB work is done
        }
    }

    @Override
    public Post getById(String postId) {
        try{
            MongoDatabase db = client.getDatabase("java-demo");
            PostDAOImpl postDAO = new PostDAOImpl(db);
            Optional<Post> posts = postDAO.findById(postId);
            if(posts.isPresent()){
                postCache.put(postId, posts.get());
            }
            return postCache.get(postId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize PostServiceImpl", e);
        } finally {
            client.close(); // close only after all DB work is done
        }
    }

    @Override
    public List<Post> getAll() {
        try{
            MongoDatabase db = client.getDatabase("java-demo");
            PostDAOImpl postDAO = new PostDAOImpl(db);
            return postDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize PostServiceImpl", e);
        } finally {
            client.close(); // close only after all DB work is done
        }
    }

    @Override
    public List<Post> searchByTitle(String keyword) {
        return List.of();
    }

    @Override
    public List<Post> getByAuthor(String authorId) {
        try{
            MongoDatabase db = client.getDatabase("java-demo");
            PostDAOImpl postDAO = new PostDAOImpl(db);
            List<Post> posts = postDAO.findByAuthorId(authorId);
            posts.forEach(post -> postCache.put(post.getId(), post));
            return posts;
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize PostServiceImpl", e);
        } finally {
            client.close(); // close only after all DB work is done
        }
    }
}