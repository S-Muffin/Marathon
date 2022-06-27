module com.example.marathon {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires kernel;
    requires layout;
    requires io;


    opens com.example.marathon to javafx.fxml;
    exports com.example.marathon;
}