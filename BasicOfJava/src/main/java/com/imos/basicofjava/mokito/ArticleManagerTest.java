/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.mokito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author INVCH018
 */
@RunWith(MockitoJUnitRunner.class)
public class ArticleManagerTest  {

       @Mock private ArticleCalculator calculator;
       @Mock private ArticleDatabase database;
       @Spy private UserProvider userProvider = new ConsumerUserProvider();

       // creates instance of ArticleManager
       // and performs constructor injection on it
       @InjectMocks private ArticleManager manager;

       @Test 
       public void shouldDoSomething() {
         // assume that ArticleManager has a method called initialize which calls a method
         // addListener with an instance of ArticleListener
         manager.initialize();
         
           // validate that addListener was called
//         verify(database).addListener(any(ArticleListener.class));
       }
} 
