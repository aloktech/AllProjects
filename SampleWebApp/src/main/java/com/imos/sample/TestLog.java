/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.invicara.xos.logger.ILog;
import org.json.JSONObject;

/**
 *
 * @author alok
 */
public class TestLog implements ILog{

    private String msg;
    
    public TestLog() {
    }
    
    public TestLog(String msg) {
        this.msg = msg;
    }
    
    @Override
    public JSONObject toJSON() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Severity getSeverity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
