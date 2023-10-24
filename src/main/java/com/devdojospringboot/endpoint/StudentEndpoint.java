package com.devdojospringboot.endpoint;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devdojospringboot.error.CustomErrorType;
import com.devdojospringboot.model.Student;
import com.devdojospringboot.util.DateUtil;

@RestController
@RequestMapping("students")
public class StudentEndpoint {
     
    @Autowired
    private DateUtil dateUtil;

    @GetMapping()
    public ResponseEntity<List<Student>> listAll() {
        // System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        // return new ResponseEntity<>(Student.studentList, HttpStatus.OK);
        return ResponseEntity.ok(Student.studentList);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Integer id) {
        Student student = new Student();
        student.setId(id);
        Integer index = Student.studentList.indexOf(student);
        
        if (index == -1) {
            return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
        }
        
        return ResponseEntity.ok(Student.studentList.get(index));
    }
}
