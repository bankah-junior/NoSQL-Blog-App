package com.amalitech.nosqlblog.service.impl;

import com.amalitech.nosqlblog.dao.TagDAO;
import com.amalitech.nosqlblog.model.Tag;
import com.amalitech.nosqlblog.service.TagService;

import java.util.List;

public class TagServiceImpl implements TagService {

    private final TagDAO tagDao;

    public TagServiceImpl(TagDAO tagDao) {
        this.tagDao = tagDao;
    }

    @Override
    public Tag create(Tag tag) {
        return tagDao.save(tag);
    }

    @Override
    public Tag getByName(String name) {
        return tagDao.findByName(name).orElse(null);
    }

    @Override
    public List<Tag> getAll() {
        return tagDao.findAll();
    }

    @Override
    public void assignTagToPost(String postId, String tagId) {
        tagDao.assignTagToPost(postId, tagId);
    }

    @Override
    public List<Tag> getTagsByPost(String postId) {
        return tagDao.findTagsByPostId(postId);
    }
}