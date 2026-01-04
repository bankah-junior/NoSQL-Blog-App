package com.amalitech.nosqlblog.controller;

import com.amalitech.nosqlblog.model.Post;
import com.amalitech.nosqlblog.service.impl.PostServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.List;

public class HomeController {

    @FXML
    private ListView<Post> blogListView;

    @FXML
    private Label username;

    @FXML
    public void initialize() {
        PostServiceImpl postService = new PostServiceImpl();
        List<Post> posts = postService.getAll();

        blogListView.getItems().addAll(posts);

        blogListView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Post post, boolean empty) {
                super.updateItem(post, empty);

                if (empty || post == null) {
                    setGraphic(null);
                } else {
                    try {
                        FXMLLoader loader = new FXMLLoader(
                                getClass().getResource("/com/amalitech/nosqlblog/blog-item.fxml")
                        );
                        Parent root = loader.load();

                        BlogItemController controller = loader.getController();
                        controller.setData(post);

                        setGraphic(root);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

     @FXML
    public void setUsername(String username) {
        this.username.setText(username);
    }
}

