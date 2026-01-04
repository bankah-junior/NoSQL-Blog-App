module com.amalitech.nosqlblog {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mongodb.driver.sync.client;
    requires org.slf4j;
    requires org.mongodb.driver.core;
    requires jbcrypt;
    requires org.mongodb.bson;


    opens com.amalitech.nosqlblog to javafx.fxml;
    exports com.amalitech.nosqlblog;
    exports com.amalitech.nosqlblog.controller;
    opens com.amalitech.nosqlblog.controller to javafx.fxml;
}