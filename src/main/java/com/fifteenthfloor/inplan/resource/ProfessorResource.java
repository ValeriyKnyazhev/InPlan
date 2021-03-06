package com.fifteenthfloor.inplan.resource;

import com.fifteenthfloor.inplan.domain.model.Professor;
import com.fifteenthfloor.inplan.domain.model.ProfessorRepository;
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
    public ResponseEntity<Object> getAllProfessors() {
        List<ProfessorModel> professors = new ArrayList<>();
        for (Professor professor : this.professorRepository.getAllProfessors()) {
            professors.add(new ProfessorModel(professor));
        }
        if (!professors.isEmpty()) {
            return ResponseEntity.ok(professors);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professors not found");
    }

    @GetMapping(value = "/all/id", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /professors/all/id
     */
    @ResponseBody
    public ResponseEntity<Object> getAllIdProfessors() {
        List<Long> professors = new ArrayList<>();
        for (Professor professor : this.professorRepository.getAllProfessors()) {
            professors.add(professor.getId());
        }
        if (!professors.isEmpty()) {
            return ResponseEntity.ok(professors);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professors not found");
    }

    @GetMapping(value = "/lastname/{lastname}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /professors/lastname/Lastname
     */
    @ResponseBody
    public ResponseEntity<Object> getProfessorsByLastname(@PathVariable String lastname) {
        List<ProfessorModel> professors = new ArrayList<>();
        for (Professor professor : this.professorRepository.getProfessorsByLastName(lastname)) {
            professors.add(new ProfessorModel(professor));
        }
        if (!professors.isEmpty()) {
            return ResponseEntity.ok(professors);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professors by name " + lastname + " not found");
    }

    @GetMapping(value = "lastname/id/{lastname}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /professors/lastname/id/Lastname
     */
    @ResponseBody
    public ResponseEntity<Object> getIdProfessorsByLastname(@PathVariable String lastname) {
        List<Long> professors = new ArrayList<>();
        for (Professor professor : this.professorRepository.getProfessorsByLastName(lastname)) {
            professors.add(professor.getId());
        }
        if (!professors.isEmpty()) {
            return ResponseEntity.ok(professors);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professors by name " + lastname + " not found");
    }

    @GetMapping(value = "/id/{id}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /professors/id/2
     */
    @ResponseBody
    public ResponseEntity<Object> getProfessor(@PathVariable long id) {
        Professor professor = this.professorRepository.getProfessor(id);
        if (professor != null) {
            return ResponseEntity.ok(new ProfessorModel(professor));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor by id " + id + " not found");
    }

}
