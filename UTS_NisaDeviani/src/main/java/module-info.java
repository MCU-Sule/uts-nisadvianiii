module com.example.uts_nisadeviani {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.uts_nisadeviani to javafx.fxml;
    exports com.example.uts_nisadeviani;
    exports com.example.uts_nisadeviani.utility;
    exports com.example.uts_nisadeviani.model;
    exports com.example.uts_nisadeviani.controller;
    opens com.example.uts_nisadeviani.controller to javafx.fxml;
    exports com.example.uts_nisadeviani.dao;
}