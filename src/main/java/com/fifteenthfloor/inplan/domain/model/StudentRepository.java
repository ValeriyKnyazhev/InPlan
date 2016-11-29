package com.fifteenthfloor.inplan.domain.model;

import com.fifteenthfloor.inplan.domain.model.Student;

import java.util.ArrayList;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
public interface StudentRepository {

    ArrayList<Student> getAllStudents();

    ArrayList<Student> getStudentsByLastName(String lastname);

    Student getStudent(long id);

    void createStudent(Student student);

}
