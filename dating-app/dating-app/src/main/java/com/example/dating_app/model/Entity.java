package com.example.dating_app.model;

public class Entity {

    private String name;
    private String gender;
    private int age;
    private String[] interests;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    public Entity() {
    }

    public Entity(String name, String gender, int age, String[] interests) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.interests = interests;
    }
}