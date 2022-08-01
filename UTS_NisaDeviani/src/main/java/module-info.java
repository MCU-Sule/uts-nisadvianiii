module com.example.uts_nisadeviani {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.uts_nisadeviani to javafx.fxml;
    exports com.example.uts_nisadeviani;
}