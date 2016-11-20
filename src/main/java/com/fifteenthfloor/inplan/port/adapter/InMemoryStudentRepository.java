package com.fifteenthfloor.inplan.port.adapter;

import com.fifteenthfloor.inplan.domain.model.Plan;
import com.fifteenthfloor.inplan.domain.model.Sex;
import com.fifteenthfloor.inplan.domain.model.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
public class InMemoryStudentRepository implements StudentRepository {

    private Set<Student> students = new HashSet<>();

    public InMemoryStudentRepository() {
        loadStudents();
    }

    private void loadStudents() {
        this.students.add(new Student("Vasiliy", "Aleksandrovich", "Pupkin", Sex.Male, new Date(397382738L), 1000, new Plan()));
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        return new ArrayList<>(this.students);
    }

    @Override
    public ArrayList<Student> getStudentsByLastName(String lastname) {
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : this.students) {
            if (student.getLastname().equals(lastname)) {
                students.add(student);
            }
        }
        return students;
    }

}
