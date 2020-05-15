package com.gorest.models;

import java.util.List;

public class User {

    private String email;
    private String name;
    private String lastname;
    private String gender;

    public User (List<String> data){
        this.email = data.get(0);
        this.name = data.get(1);
        this.lastname = data.get(2);
        this.gender = data.get(3);
    }

    @Override
    public String toString(){
        return "{\"email\": \""+ email +"\",\"first_name\": \""+ name +"\",\"last_name\": \""+ lastname +"\", \"gender\": \""+ gender +"\"}";
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
