package org.example.fx.controller.events;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MyMouseExitedEvent implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println("El Raton Ha Salido");
    }
}
