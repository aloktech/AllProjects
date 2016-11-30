/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.followme.north;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javax.inject.Inject;

/**
 * FXML Controller class
 *
 * @author Alok
 */
public class NorthPresenter implements Initializable {

    @Inject
    NorthService dms;
    
    @FXML
    Button ok;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void show() {
        dms.show();
    }
}
