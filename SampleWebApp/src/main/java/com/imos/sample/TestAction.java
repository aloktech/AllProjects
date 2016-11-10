/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.invicara.xos.core.requests.RequestException;
import com.invicara.xos.core.requests.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author alok
 */
public class TestAction implements IAction {

    Logger LOGGER = LoggerFactory.getLogger(TestAction.class);

    public TestAction() {
        RequestManager.setRequestContext(TestContext.class);
    }
    
    @Override
    public void execute() {
        try {
            RequestManager.execute(new TestRequest());
            
            throw new RequestException.Builder()
                    .message("Testing")
                    .eventName("Testing Event")
                    .build();
        } catch (RequestException ex) {
            LOGGER.error(ex.getEventName() + " : " + ex.getMessage());
        }
    }

}
