package com.devdojospringboot.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class Student implements Serializable{

    private Integer id;
    private String name;
    public static List<Student> studentList;

    static {
        studentRepository();
    }

    public Student(Integer id, String name) {
        this(name);
        this.id = id;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(){}

    public static void studentRepository() {
        studentList = Arrays.asList(new Student(1, "Carlos"), new Student(2, "Eduardo"));
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
