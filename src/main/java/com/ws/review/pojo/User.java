package com.ws.review.pojo;

public class User {
    private int id;
    private String user_name;
    private String password;
    private int number_file_owned;
    public User(){

    }

    public User(int id, String user_name, String password, int number_file_owned) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.number_file_owned = number_file_owned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumber_file_owned() {
        return number_file_owned;
    }

    public void setNumber_file_owned(int number_file_owned) {
        this.number_file_owned = number_file_owned;
    }
}
