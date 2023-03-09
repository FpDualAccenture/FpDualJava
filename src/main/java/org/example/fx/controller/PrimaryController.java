package org.example.fx.controller;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.example.fx.App;
import org.example.fx.controller.events.MyKeyEvent;
import org.example.fx.controller.events.MyMouseEnteredEvent;
import org.example.fx.controller.events.MyMouseExitedEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Primary Controller Class.
 * @author jose.m.prieto.villar
 */
public class PrimaryController implements Initializable {

    @FXML
    private Button primaryButton;

    @FXML
    private ImageView boxImage;

    @FXML
    private TextField campoTexto;

    @FXML
    private AnchorPane anchorPane;

    /**
     * switch to secondary window.
     * @throws {@code IOException}
     */
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

//    @FXML
//    private void printKey(KeyEvent event){
//        System.out.println(event.getText());
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //campoTexto.setOnKeyPressed(key -> System.out.println(key.getText()));

        anchorPane.addEventFilter(KeyEvent.KEY_RELEASED, new MyKeyEvent());

        primaryButton.setText("Boton Inicial");

        boxImage.setOnMouseEntered(new MyMouseEnteredEvent());
        boxImage.setOnMouseExited(new MyMouseExitedEvent());
        boxImage.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> System.out.println("Clicked!!!!"));

        Rectangle clip = new Rectangle(
                boxImage.getFitWidth(), boxImage.getFitHeight()
        );
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        boxImage.setClip(clip);

        // snapshot the rounded image.
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        WritableImage image = boxImage.snapshot(parameters, null);

        // remove the rounding clip so that our effect can show through.
        boxImage.setClip(null);

        // apply a shadow effect.
        boxImage.setEffect(new DropShadow(20, Color.BLACK));

        // store the rounded image in the imageView.
        boxImage.setImage(image);
    }
}
