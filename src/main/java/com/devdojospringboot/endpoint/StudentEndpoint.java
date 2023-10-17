package com.devdojospringboot.endpoint;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devdojospringboot.model.Student;
import com.devdojospringboot.util.DateUtil;

@RestController
@RequestMapping("student")
public class StudentEndpoint {
     
    @Autowired
    private DateUtil dateUtil;

    @GetMapping(path = "/list")
    public ResponseEntity<List<Student>> listAll() {
        System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(Arrays.asList(new Student("Carlos"), new Student("Eduardo")));
    }
}
