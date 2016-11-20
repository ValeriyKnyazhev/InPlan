package com.fifteenthfloor.inplan.resource;

import com.fifteenthfloor.inplan.domain.model.Student;
import com.fifteenthfloor.inplan.domain.model.StudentRepository;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
        ArrayList<Student> students = this.studentRepository.getAllStudents();
        if (students != null) {
            return ResponseEntity.ok(students);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Students not found");
    }

    @GetMapping(produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /students?lastname=Lastname
     */
    @ResponseBody
    public ResponseEntity<Object> getAccount(@RequestParam(value = "lastname") String lastname) {
        ArrayList<Student> students = this.studentRepository.getStudentsByLastName(lastname);
        if (students != null) {
            return ResponseEntity.ok(students);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Students not found");
    }

}
