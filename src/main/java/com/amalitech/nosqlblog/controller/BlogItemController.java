package com.amalitech.nosqlblog.controller;

import com.amalitech.nosqlblog.model.Post;
import com.amalitech.nosqlblog.model.User;
import com.amalitech.nosqlblog.utils.exceptions.UserInputsException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BlogItemController {

    public Button sharePostButton;
    public Button editPostButton;
    public Button deletePostButton;
    public Button postCommentButton;
    @FXML private Label titleLabel;
    @FXML private Label authorLabel;
    @FXML private Label contentLabel;

    public void setData(Post post) {
        try {
            UserController userController = new UserController();
            User author = userController.getById(post.getAuthorId());
            titleLabel.setText(post.getTitle());
            authorLabel.setText("By " + author.getUsername());
            contentLabel.setText(post.getContent());
        } catch (UserInputsException e) {
            System.err.println("Error loading blog item: " + e.getMessage());
        }
    }
}

