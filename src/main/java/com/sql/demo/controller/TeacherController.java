package com.sql.demo.controller;

import com.sql.demo.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TeacherController {

    private TeacherService teacherService;

    @GetMapping("/printteachers")
    public ResponseEntity<String> printAllTeachersToFile() {
        teacherService.printAllTeachersToFile();
        return ResponseEntity.ok("Teachers printed to file");
    }

    @PostMapping("/saveteacher")
    public ResponseEntity<String> saveTeacher() {
        teacherService.saveTeacher();
        return ResponseEntity.ok("Teacher saved");
    }
}
