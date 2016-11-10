package com.imos.sample.samplejavafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FXMLController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        System.out.println(Thread.currentThread());
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
            }
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(Thread.currentThread());
    }
}
