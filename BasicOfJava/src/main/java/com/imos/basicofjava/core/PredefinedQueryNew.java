/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.core;

import lombok.Builder;
import lombok.Getter;
import org.json.JSONObject;

/**
 *
 * @author alok
 */
@Getter
@Builder
public class PredefinedQueryNew {

    private final String name;
    private String view = "";
    private JSONObject params = new JSONObject();

    public static class PredefinedQueryNewBuilder implements IBuilder<PredefinedQueryNew> {

        public PredefinedQueryNewBuilder() {
        }
    }
}
