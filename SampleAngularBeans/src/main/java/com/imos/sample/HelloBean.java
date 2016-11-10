/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import angularBeans.api.AngularBean;
import angularBeans.api.NGModel;
import angularBeans.api.NGReturn;
import angularBeans.api.NGSubmit;
import angularBeans.api.http.Get;

/**
 *
 * @author alok
 */
@AngularBean
public class HelloBean {

    private String message;
    private String name = "insert your name here";

    @Get
    @NGSubmit(backEndModels = "name")
    @NGReturn(updates = "message")
    public void sayHello() {
        message = "Hello " + name + "from angularBeans !";
    }

    @NGModel
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @NGModel
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
