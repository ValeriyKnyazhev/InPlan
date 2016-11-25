package com.fifteenthfloor.inplan.resource;

import com.fifteenthfloor.inplan.domain.model.Professor;
import com.fifteenthfloor.inplan.domain.model.ProfessorRepository;
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
 * @author Valeriy Knyazhev
 */
@RestController
@RequestMapping(value = "/professors")
public class ProfessorResource {

    private ProfessorRepository professorRepository;

    public ProfessorResource(@NonNull ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @GetMapping(value = "/all", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /professors/all
     */
    @ResponseBody
    public ResponseEntity<Object> getAllStudents() {
        List<ProfessorModel> professors = new ArrayList<>();
        for (Professor professor : this.professorRepository.getAllProfessors()) {
            professors.add(new ProfessorModel(professor));
        }
        if (!professors.isEmpty()) {
            return ResponseEntity.ok(professors);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professors not found");
    }

    @GetMapping(produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /professors?lastname=Lastname
     */
    @ResponseBody
    public ResponseEntity<Object> getStudentByLastname(@RequestParam(value = "lastname") String lastname) {
        List<ProfessorModel> professors = new ArrayList<>();
        for (Professor professor : this.professorRepository.getProfessorsByLastName(lastname)) {
            professors.add(new ProfessorModel(professor));
        }
        if (!professors.isEmpty()) {
            return ResponseEntity.ok(professors);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professors by name " + lastname + " not found");
    }

    @GetMapping(value = "/{id}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /professors/2
     */
    @ResponseBody
    public ResponseEntity<Object> getStudent(@PathVariable long id) {
        Professor professor = this.professorRepository.getProfessor(id);
        if (professor != null) {
            return ResponseEntity.ok(new ProfessorModel(professor));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor by id " + id + " not found");
    }


}
