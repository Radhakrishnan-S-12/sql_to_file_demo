package com.sql.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TEACHER_TABLE")
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "TEACHER_NAME")
    private String teacherName;

    @Column(name = "TEACHER_EMAIL")
    private String teacherEmail;

    @ManyToOne
    @JoinColumn(name = "classes_id", nullable = false)
    private Classes classes;

    @Override
    public String toString() {
        return id +
                " " + teacherName +
                " " + teacherEmail +
                " " + classes;
    }
}
