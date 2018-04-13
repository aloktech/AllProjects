/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author ameher
 */
class BeanAdapter extends XmlAdapter<String, String>{

    @Override
    public String unmarshal(String v) throws Exception {
        return v;
    }

    @Override
    public String marshal(String v) throws Exception {
        return v;
    }
    
}
