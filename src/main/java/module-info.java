module com.example.autoclicker_v1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.autoclicker_v1 to javafx.fxml;
    exports com.example.autoclicker_v1;
}