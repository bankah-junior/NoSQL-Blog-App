package com.amalitech.nosqlblog;

import com.amalitech.nosqlblog.controller.UserController;
import com.amalitech.nosqlblog.model.Post;
import com.amalitech.nosqlblog.model.User;
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
        UserController userController = new UserController();
        User author = userController.getById(post.getAuthorId());
        titleLabel.setText(post.getTitle());
        authorLabel.setText("By " + author.getUsername());
        contentLabel.setText(post.getContent());
    }
}

