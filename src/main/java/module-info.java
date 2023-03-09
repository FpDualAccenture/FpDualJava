module org.example.fx {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.fx to javafx.fxml;
    opens org.example.fx.controller to javafx.fxml;
    exports org.example.fx;
}