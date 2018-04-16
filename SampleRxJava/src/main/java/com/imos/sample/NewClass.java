/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import rx.Observable;

/**
 *
 * @author Pintu
 */
public class NewClass {

    public static void main(String[] args) {

        hello(new String[]{"Alok", "Ranjan", "Meher"});
    }

    public static void hello(String... names) {
        Observable.from(names)
                .subscribe((s) -> {
                    System.out.println("Hello " + s + "!");
                });
    }
}
