/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author PARAM 2000
 */
@ManagedBean(name = "userTable")
@SessionScoped
public class UserTableBean implements Serializable {

    @ManagedProperty(value = "#{user}")
    UserBean user;
    private List<UserBean> allUserName = new ArrayList<>();

    private List<UserBean> filterUser = new ArrayList<>();

    public UserTableBean() {
    }

    public void addName(ActionEvent event) {
        if (user.getName() == null || user.getName().isEmpty()) {

        } else {
            UserBean tempUser = new UserBean();
            tempUser.setName(user.getName());
            allUserName.add(tempUser);
        }
    }

    public List<UserBean> getAllUserName() {
        return allUserName;
    }

    public void setAllUserName(List<UserBean> allUserName) {
        this.allUserName = allUserName;
    }

    public List<UserBean> getFilterUser() {
        return filterUser;
    }

    public void setFilterUser(List<UserBean> filterUser) {
        this.filterUser = filterUser;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

}
