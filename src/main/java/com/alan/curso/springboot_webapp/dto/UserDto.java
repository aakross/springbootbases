package com.alan.curso.springboot_webapp.dto;

import com.alan.curso.springboot_webapp.models.User;

public class UserDto {
    private String title;
    //    private String name;
    private User user;
//    private String lastname;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
//    public String getLastname() {
//        return lastname;
//    }
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }

}
