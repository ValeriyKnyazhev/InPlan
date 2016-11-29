package com.fifteenthfloor.inplan.port.adapter;

import com.fifteenthfloor.inplan.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
@Repository
public class InMemoryStudentRepository implements StudentRepository {

    private List<Student> students = new ArrayList<>();

    @Autowired
    PlanRepository planRepository;

    public InMemoryStudentRepository() {
        loadStudents();
    }

    private void loadStudents() {
        createStudent(new Student("Vasiliy", "Aleksandrovich", "Pupkin", "pupkinap", "pupkinap@mail.com", "jk3g2ged329i32ye", Sex.Male, new Date(324521564643643L), 15000));
        createStudent(new Student("Vladimir", "Vladimirovich", "Putin", "putinvv", "putinvv@mail.com", "ji4rjnfuf", Sex.Male, new Date(45454367456L), 999999999));
        createStudent(new Student("Aleksandr", "Sergeevich", "Vasiliev", "vasilievas", "vasilievas@mail.com", "3rnbij32nifewnd", Sex.Male, new Date(4532546576864334543L), 79217924));
        createStudent(new Student("Aleksey", "Vladimirovich", "Kozlov", "kozlovav", "kozlovav@mail.com", "fj43fnoin43fk3ff", Sex.Male, new Date(7409871875L), 40932809));
        createStudent(new Student("Andrey", "Igorevich", "Ivanov", "ivanovai", "ivanovai@mail.com", "lmpk3m3ebjnm1o123325sa", Sex.Male, new Date(467485349864874L), 321466474));
        createStudent(new Student("Ivan", "Aleksandrovich", "Sidorov", "iasidorov", "iasidorov@mail.com", "do3msbh3xiurhiuhgd", Sex.Male, new Date(472143218980845635L), 4124324));
        createStudent(new Student("Valeriy", "Aleksandrovich", "Medvedev", "vamedvedev", "pupvamedvedevkinap@mail.com", "fdewkjbewihiuhkj32n32e3u32", Sex.Male, new Date(56458798912368L), 324123));
        createStudent(new Student("Sergey", "Ivanovich", "Petrov", "petrov96", "petrov96@mail.com", "sdpo3opk4m09855jfo", Sex.Male, new Date(2348648719709793131L), 11111));
        createStudent(new Student("Pavel", "Andreevich", "Kozel", "kozel_97", "kozel_97@mail.com", "p090jrm87st3m9dy45nf", Sex.Male, new Date(345325543252511L), 432546));
        createStudent(new Student("Dmitriy", "Alekseevich", "Trump", "usa_great_again", "usa_great_again@mail.com", "sdkjneij332bx9uek932087sdftr", Sex.Male, new Date(794923085305376L), 325245436));
        createStudent(new Student("Svetlana", "Andreevna", "Popova", "svetochka_popova", "svetochka_popova@mail.com", "4c3t45yxz33d32", Sex.Female, new Date(43242113136L), 432546));
        createStudent(new Student("Ekaterina", "Aleksandrovna", "Medvedeva", "medved_kat", "medved_kat@mail.com", "nkjn84hr439i43", Sex.Female, new Date(687698768743L), 123123));
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

    @Override
    public void createStudent(Student student) {
        if (getStudent(student.getId()) == null) {
            this.students.add(student);
            planRepository.createPlan(new Plan(student.getPlan()));
        }
    }

}
