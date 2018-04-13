/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.owlike.genson.GenericType;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ameher
 */
public class Sample {

    public static void main(String[] args) {
//        part1();

        Genson genson = new GensonBuilder()
                .useDateFormat(new SimpleDateFormat("yyyy-MM-dd"))
                .useIndentation(true)
                .useConstructorWithArguments(true)
                .create();

        Person person = genson.deserialize("{\"age\":28,\"name\":\"Foo\"}", Person.class);
        System.out.println(person);
        person.setDateOfBirth(new Date());
        String json = genson.serialize(person);
        System.out.println(json);
    }

    private static void part1() {
        Genson genson = new GensonBuilder()
                .useDateFormat(new SimpleDateFormat("yyyy-MM-dd"))
                .useIndentation(true)
                .useConstructorWithArguments(true)
                .create();

        AwesomeBean bean = new Genson().deserialize("{}", AwesomeBean.class);
        System.out.println(bean);

//        genson = new Genson();
// read from a String, byte array, input stream or reader
        Person person = genson.deserialize("{\"age\":28,\"name\":\"Foo\"}", Person.class);
        System.out.println(person);
        person.setDateOfBirth(new Date());
        String json = genson.serialize(person);
        System.out.println(json);
// or produce a byte array
        byte[] jsonBytes = genson.serializeBytes(person);
// or serialize to a output stream or writer
        System.out.println(genson.serialize(person));

        json = "[{\"age\":39,\"name\":\"Foo\"}]";

        List<Person> persons = genson.deserialize(json, new GenericType<List<Person>>() {
        });
        System.out.println(persons);

        Map<Integer, Object> map = genson.deserialize(
                "{\"1\":28, \"2\":\"Foo\"}",
                new GenericType<Map<Integer, Object>>() {
        }
        );
        System.out.println(map);

        int[] arrayOfInts = new int[]{1, 2, 3};
// json = [1,2,3]
        json = genson.serialize(arrayOfInts);
        System.out.println(json);
    }

}
