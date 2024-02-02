package com.fonsdev.library.User;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name") private String name;
    @Column(name = "email") private String email;
    @Column(name = "age") private Integer age;

    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
