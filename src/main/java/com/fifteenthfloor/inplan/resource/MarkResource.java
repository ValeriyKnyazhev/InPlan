package com.fifteenthfloor.inplan.resource;

import com.fifteenthfloor.inplan.domain.model.MarkRepository;
import com.fifteenthfloor.inplan.port.adapter.MarkAlreayExistsException;
import com.fifteenthfloor.inplan.port.adapter.MarkNotFoundException;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Valeriy Knyazhev
 */
@RestController
@RequestMapping(value = "/marks")
public class MarkResource {

    @Autowired
    private MarkRepository markRepository;

    public MarkResource(@NonNull MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    @GetMapping(value = "/student/{student}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /marks/student/11
     */
    @ResponseBody
    public ResponseEntity<Object> getMarksByStudent(@PathVariable long student) {
        ArrayList<MarkModel> models = this.markRepository.findByStudent(student);
        if (!models.isEmpty()) {
            return ResponseEntity.ok(models);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marks not found");
    }

    @GetMapping(value = "/professor/{professor}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /marks/professor/5
     */
    @ResponseBody
    public ResponseEntity<Object> getMarksByProfessor(@PathVariable long professor) {
        ArrayList<MarkModel> models = this.markRepository.findByProfessor(professor);
        if (!models.isEmpty()) {
            return ResponseEntity.ok(models);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marks not found");
    }

    @GetMapping(value = "/course/{course}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /marks/course/1
     */
    @ResponseBody
    public ResponseEntity<Object> getMarksByCourse(@PathVariable long course) {
        ArrayList<MarkModel> models = this.markRepository.findByCourse(course);
        if (!models.isEmpty()) {
            return ResponseEntity.ok(models);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marks not found");
    }

    @GetMapping(value = "/id/{id}", produces = {APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public ResponseEntity<Object> getAccount(@PathVariable long id) {
        MarkModel model = this.markRepository.find(id);
        if (model != null) {
            return ResponseEntity.ok(model);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mark not found");
    }

    @PutMapping(value = "/id/{id}", consumes = {APPLICATION_JSON_UTF8_VALUE},
            produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    PUT /marks/id/{id}
    {
        "value": 5,
        "student": 11,
        "professor": 5,
        "course": 1,
        "description": "me description"
    }
     */
    @ResponseBody
    public ResponseEntity<Object> putAccount(@PathVariable long id, @RequestBody MarkModel model) {
        this.markRepository.update(id, model);
        return ResponseEntity.ok(model);
    }

    @PostMapping(consumes = {APPLICATION_JSON_UTF8_VALUE},
            produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    POST /marks
    {
        "value": 5,
        "student": 11,
        "professor": 5,
        "course": 1,
        "description": "my description"
    }
     */
    @ResponseBody
    public ResponseEntity<Object> postAccount(@RequestBody MarkModel model) {
        this.markRepository.create(model);
        return ResponseEntity.ok(model);
    }

    @DeleteMapping(value = {"/id/{id}"})
    @ResponseBody
    public ResponseEntity<Object> deleteAccount(@PathVariable long id) {
        this.markRepository.remove(id);
        return ResponseEntity.ok(id);
    }

    @ExceptionHandler(MarkAlreayExistsException.class)
    public ResponseEntity<Object> resourceException(MarkAlreayExistsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(MarkNotFoundException.class)
    public ResponseEntity<Object> resourceException(MarkNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }


}
