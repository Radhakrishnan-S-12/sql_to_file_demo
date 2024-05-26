package com.sql.demo.service;

import com.sql.demo.model.Classes;
import com.sql.demo.model.Teacher;
import com.sql.demo.repository.ClassesRepository;
import com.sql.demo.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final ClassesRepository classesRepository;

    @Value("${file.path}")
    private String outputDirectory;
    @Value("${file.name}")
    private String outputFileName;

    public void printAllTeachersToFile() {
        List<Teacher> teachers = findAllTeachers();
        File file = new File(outputDirectory + outputFileName);
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (Teacher teacher : teachers) {
                fileWriter.write("TEACHER_Id - " + teacher.getId() + ", TEACHER_NAME - " + teacher.getTeacherName()
                        + ", TEACHER_EMAIL - " + teacher.getTeacherEmail()
                        + ", CLASS_Id - " + teacher.getClasses().getId() + ", CLASS_NAME - " + teacher.getClasses().getClassName()
                        + ", CLASS_CODE - " + teacher.getClasses().getClassCode()
                        + ", NUMBER_OF_STUDENTS - " + teacher.getClasses().getNumberOfStudents() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    public void saveTeacher() {

        Classes classes = new Classes();
        classes.setClassCode("CS101");
        classes.setClassName("Computer Science");
        classes.setNumberOfStudents(50L);

        Classes classes2 = new Classes();
        classes2.setClassCode("MTH101");
        classes2.setClassName("Maths");
        classes2.setNumberOfStudents(50L);

        List<Classes> classesList = new ArrayList<>();
        classesList.add(classes);
        classesList.add(classes2);
        classesRepository.saveAll(classesList);

        Teacher teacher1 = new Teacher();
        teacher1.setTeacherName("Radhakrishnan");
        teacher1.setTeacherEmail("radkrish@gmail.com");
        teacher1.setClasses(classes);

        Teacher teacher2 = new Teacher();
        teacher2.setTeacherName("Jayanthi");
        teacher2.setTeacherEmail("jay@gmail.com");
        teacher2.setClasses(classes2);

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacher1);
        teacherList.add(teacher2);

        teacherRepository.saveAll(teacherList);
    }

}