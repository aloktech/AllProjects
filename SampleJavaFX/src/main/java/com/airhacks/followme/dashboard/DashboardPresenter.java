package com.airhacks.followme.dashboard;

/*
 * #%L
 * igniter
 * %%
 * Copyright (C) 2013 - 2016 Adam Bien
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.airhacks.followme.dashboard.light.LightView;
import com.airhacks.followme.north.NorthView;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.converter.NumberStringConverter;
import javax.inject.Inject;

/**
 *
 * @author adam-bien.com
 */
public class DashboardPresenter implements Initializable {

    @FXML
    Label message;
    
    @FXML
    Label a;
    
    @FXML
    TextField b;
    
    @FXML
    TextField c;

    @FXML
    Pane lightsBox;

    @Inject
    Tower tower;

    @Inject
    private String prefix;

    @Inject
    private String happyEnding;

    @Inject
    private LocalDate date;

    private String theVeryEnd;
    
    @FXML
    AnchorPane south;

    IntegerProperty bNumber = new SimpleIntegerProperty();
    IntegerProperty cNumber = new SimpleIntegerProperty();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //fetched from dashboard.properties
        this.theVeryEnd = rb.getString("theEnd");
        
        Bindings.bindBidirectional(b.textProperty(), bNumber, new NumberStringConverter());
        Bindings.bindBidirectional(c.textProperty(), cNumber, new NumberStringConverter());
        
        a.textProperty().bind(bNumber.add(cNumber).asString());
        
        NorthView northView = new NorthView();
//        south.getChildren().add(northView.getView());
        northView.getViewAsync(south.getChildren()::add);
    }

    public void createLights() {
        for (int i = 0; i < 255; i++) {
            final int red = i;
            LightView view = new LightView((f) -> red);
            view.getViewAsync(lightsBox.getChildren()::add);
        }
    }

    public void launch() {
        message.setText("Date: " + date + " -> " + prefix + tower.readyToTakeoff() + happyEnding + theVeryEnd
        );
    }

}
