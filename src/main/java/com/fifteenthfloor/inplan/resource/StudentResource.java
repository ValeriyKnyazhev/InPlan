package com.fifteenthfloor.inplan.resource;

import com.fifteenthfloor.inplan.domain.model.Student;
import com.fifteenthfloor.inplan.domain.model.StudentRepository;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
@RestController
@RequestMapping(value = "/students")
public class StudentResource {

    private StudentRepository studentRepository;

    public StudentResource(@NonNull StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping(value = "/all", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /students/all
     */
    @ResponseBody
    public ResponseEntity<Object> getAllStudents() {
        List<StudentModel> students = new ArrayList<>();
        for (Student student : this.studentRepository.getAllStudents()) {
            students.add(new StudentModel(student));
        }
        if (!students.isEmpty()) {
            return ResponseEntity.ok(students);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Students not found");
    }

    @GetMapping(value = "/all/id", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /students/all/id
     */
    @ResponseBody
    public ResponseEntity<Object> getAllIdStudents() {
        List<Long> students = new ArrayList<>();
        for (Student student : this.studentRepository.getAllStudents()) {
            students.add(student.getId());
        }
        if (!students.isEmpty()) {
            return ResponseEntity.ok(students);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Students not found");
    }

    @GetMapping(value = "/lastname/{lastname}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /students/lastname/Lastname
     */
    @ResponseBody
    public ResponseEntity<Object> getStudentsByLastname(@PathVariable String lastname) {
        List<StudentModel> students = new ArrayList<>();
        for (Student student : this.studentRepository.getStudentsByLastName(lastname)) {
            students.add(new StudentModel(student));
        }
        if (!students.isEmpty()) {
            return ResponseEntity.ok(students);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Students by name " + lastname + " not found");
    }

    @GetMapping(value = "/lastname/id/{lastname}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /students/lastname/id/Lastname
     */
    @ResponseBody
    public ResponseEntity<Object> getIdStudentsByLastname(@PathVariable String lastname) {
        List<Long> students = new ArrayList<>();
        for (Student student : this.studentRepository.getStudentsByLastName(lastname)) {
            students.add(student.getId());
        }
        if (!students.isEmpty()) {
            return ResponseEntity.ok(students);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Students by name " + lastname + " not found");
    }

    @GetMapping(value = "/id/{id}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /students/id/3
     */
    @ResponseBody
    public ResponseEntity<Object> getStudent(@PathVariable long id) {
        Student student = this.studentRepository.getStudent(id);
        if (student != null) {
            return ResponseEntity.ok(new StudentModel(student));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student by id " + id + " not found");
    }

}
