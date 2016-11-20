package com.fifteenthfloor.inplan.domain.model;

import com.fifteenthfloor.inplan.domain.model.Student;

import java.util.ArrayList;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
public interface StudentRepository {

    public ArrayList<Student> getAllStudents();

    public ArrayList<Student> getStudentsByLastName(String lastname);

}
