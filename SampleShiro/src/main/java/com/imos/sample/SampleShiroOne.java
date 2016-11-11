/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.imos.sample;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;

/**
 *
 * @author alok
 */
public class SampleShiroOne {

    public static void main(String[] args) {
        System.out.println("s");

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        //Example using most common scenario: 
        //String username and password.  Acquire in 
        //system-specific manner (HTTP request, GUI, etc)
        UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");

        //”Remember Me” built-in, just do this:         
        token.setRememberMe(true);

        //With most of Shiro, you'll always want to make sure you're working with the currently 
        //executing user, referred to as the subject 
        Subject currentUser = SecurityUtils.getSubject();

        //Authenticate the subject by passing 
        //the user name and password token 
        //into the login method 
        currentUser.login(token);

        try {
            currentUser.login(token);
        } catch (UnknownAccountException uae) {
        } catch (IncorrectCredentialsException ice) {
        } catch (LockedAccountException lae) {
        } catch (ExcessiveAttemptsException eae) {
        } catch (AuthenticationException ae) {
        }
    }
}
