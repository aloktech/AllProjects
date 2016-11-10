/**
 * ****************************************************************************
 *
 * INVICARA INC CONFIDENTIAL __________________
 *
 * Copyright (C) [2012] - [2014] INVICARA INC, INVICARA Pte Ltd, INVICARA INDIA
 * PVT LTD All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property of
 * Invicara Inc and its suppliers, if any. The intellectual and technical
 * concepts contained herein are proprietary to Invicara Inc and its suppliers
 * and may be covered by U.S. and Foreign Patents, patents in process, and are
 * protected by trade secret or copyright law. Dissemination of this information
 * or reproduction of this material is strictly forbidden unless prior written
 * permission is obtained from Invicara Inc.
 */
package com.imos.sample;

import com.invicara.xos.core.resources.IConvertToJSON;
import org.json.JSONObject;

/**
 *
 * @author dainmorningstar
 */
public class TokenResource implements IConvertToJSON {
    
    private JSONObject m_json;

    public TokenResource() {
        m_json = new JSONObject();
    }

    public TokenResource(String token) {
        this();
        this.m_json.put("token", token);
    }
    
    public String getToken(){
        return m_json.getString("token");
    }

    @Override
    public String toString() {
        return m_json.toString();
    }
    
    @Override
    public JSONObject toJSON() {
        return m_json;
    }
    
    
}
