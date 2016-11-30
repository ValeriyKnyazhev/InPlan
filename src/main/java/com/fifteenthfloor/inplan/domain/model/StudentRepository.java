package com.fifteenthfloor.inplan.domain.model;

import java.util.ArrayList;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
public interface StudentRepository {

    ArrayList<Student> getAllStudents();

    ArrayList<Student> getStudentsByLastName(String lastname);

    Student getStudent(long id);

    void createStudent(Student student, long specialization);

    void createStudent(Student student, Long[] courses, long specialization);

}
