package com.Project_practice.demo_Practice.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String rollno;
    String gender;
    private String email;
    Integer age;
    String course;
    boolean enroll;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRollno() {
        return rollno;
    }
    public void setRollno(String rollno) {
        this.rollno = rollno;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public boolean isEnroll() {
        return enroll;
    }
    public void setEnroll(boolean enroll) {
        this.enroll = enroll;
    }
   
    public String getRollNo() {
    return rollno;
}
public void setRollNo(String rollno) {
    this.rollno = rollno;
}




}
