package com.imos.sample;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pintu
 */
public class SampleTest {

    SampleClass cls = new SampleClass();

    @Test
    public void shouldFailWhenGivenFalse() {
        assertEquals("FAIL", cls.foo(false));
    }

    @Test
    public void shouldBeOkWhenGivenTrue() {
        assertEquals("OK", cls.foo(true));
    }

    @Test
    public void addTest() {
        assertEquals(3, cls.add(1, 2));
    }

    @Test
    public void minusTest() {
        assertEquals(1, cls.minus(3, 2));
    }

    @Test
    public void countTest1() {
        int value = cls.counter;
        cls.count(3);
        assertEquals(value + 1, cls.counter);
    }

    @Test
    public void countTest2() {
        int value = cls.counter;
        cls.count(13);
        assertEquals(value, cls.counter);
    }

    @Test
    public void countTest3() {
        int value = cls.counter;
        cls.count(10);
        assertEquals(value, cls.counter);
    }
}
