package com.fifteenthfloor.inplan.port.adapter;

import com.fifteenthfloor.inplan.domain.model.*;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
@Repository
public class InMemoryStudentRepository implements StudentRepository {

    private Set<Student> students = new HashSet<>();

    public InMemoryStudentRepository() {
        loadStudents();
    }

    private void loadStudents() {
        this.students.add(new Student("Vasiliy", "Aleksandrovich", "Pupkin", "pupkinap", "pupkinap@mail.com", "jk3g2ged329i32ye", Sex.Male, new Date(46746747642342L), 1000, new Plan()));
        this.students.add(new Student("Vladimir", "Vladimirovich", "Putin", "putinvv", "putinvv@mail.com", "ji4rjnfuf", Sex.Male, new Date(4868968992427L), 999000, new Plan()));
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

    @Override
    public Student getStudent(long id) {
        return this.students.stream().filter(st -> id == st.getId()).findFirst().orElse(null);
    }

}
