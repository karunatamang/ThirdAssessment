package com.example.thirdassessment.model;

public class Users {
    String age;
    String name;
    String address;
    String gender;

    public Users(String age, String name, String address, String gender) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }
}