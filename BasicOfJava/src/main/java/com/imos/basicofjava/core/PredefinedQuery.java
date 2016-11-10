
/**
 * ****************************************************************************
 *
 * INVICARA INC CONFIDENTIAL __________________
 *
 * Copyright (C) [2012] - [2016] INVICARA INC, INVICARA Pte Ltd, INVICARA INDIA
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
package com.imos.basicofjava.core;

import org.json.JSONObject;

/**
 *
 * @author coryvanhooser
 */
public class PredefinedQuery{    
    private String name;
    private String view = "";
    private JSONObject params = new JSONObject();

    private PredefinedQuery(){}

    public String getName(){
        return name;
    }

    public String getView(){
        return view;
    }

    public JSONObject getParams(){
        return params;
    }

    public static class Builder implements IBuilder<PredefinedQuery> {
        private final PredefinedQuery query = new PredefinedQuery();

        public Builder name(String name){
            query.name = name.toLowerCase();
            return this;
        }

        public Builder view(String view){
            query.view = view.toLowerCase();
            return this;
        }

        public Builder params(JSONObject params){
            query.params = params;
            return this;
        }

        @Override
        public PredefinedQuery build(){
            assert query.name != null;
            return query;
        }
    }

}