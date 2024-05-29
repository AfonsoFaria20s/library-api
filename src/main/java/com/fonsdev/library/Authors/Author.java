package com.fonsdev.library.Authors;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Author{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "contact")
    private String contact;
    @Column(name = "age")
    private Integer age;
    @Column(name = "bio")
    private String bio;

    public Author() {}

    public Author(String name, String contact, Integer age, String bio) {
        this.name = name;
        this.contact = contact;
        this.age = age;
        this.bio = bio;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", age=" + age +
                ", bio='" + bio + '\'' +
                '}';
    }
}
