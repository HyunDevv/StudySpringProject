package com.example.objectmapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;


    public User() {
        this.name = null;
        this.age = 0;
        this.phoneNumber = null;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // 따로 메소드를 만들 때 getDefaultUser 이름으로 사용하면 getMapper에서 이름의 get을 보기 때문에 에러가 난다!!
    public User defaultUser(){
        return new User("default",0,"-");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
