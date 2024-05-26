package com.sql.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CLASS_TABLE")
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "CLASS_NAME")
    private String className;

    @Column(name = "CLASS_CODE")
    private String classCode;

    @Column(name = "NUMBER_OF_STUDENTS")
    private Long numberOfStudents;

    @OneToMany(mappedBy = "classes")
    private List<Teacher> teacherName;
}
