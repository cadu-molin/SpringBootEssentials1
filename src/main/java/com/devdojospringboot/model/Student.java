package com.devdojospringboot.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Student implements Serializable{
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public Student(){}
}
