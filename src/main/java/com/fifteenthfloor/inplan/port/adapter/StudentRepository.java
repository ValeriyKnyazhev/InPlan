package com.fifteenthfloor.inplan.port.adapter;

import com.fifteenthfloor.inplan.domain.model.Student;

import java.util.ArrayList;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
public interface StudentRepository {

    public ArrayList<Student> getAllStudents();

    public ArrayList<Student> getStudentByLastName(String lastname);

}
