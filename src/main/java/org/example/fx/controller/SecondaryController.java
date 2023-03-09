package org.example.fx.controller;

import javafx.fxml.FXML;
import org.example.fx.App;

import java.io.IOException;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}