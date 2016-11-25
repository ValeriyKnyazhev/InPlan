package com.fifteenthfloor.inplan.resource;

import com.fifteenthfloor.inplan.domain.model.Deanery;
import com.fifteenthfloor.inplan.domain.model.DeaneryRepository;
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
@RequestMapping(value = "/deaneries")
public class DeaneryResource {

    private DeaneryRepository deaneryRepository;

    public DeaneryResource(@NonNull DeaneryRepository deaneryRepository) {
        this.deaneryRepository = deaneryRepository;
    }

    @GetMapping(value = "/all", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /professors/all
     */
    @ResponseBody
    public ResponseEntity<Object> getAllStudents() {
        List<DeaneryModel> deaneries = new ArrayList<>();
        for (Deanery deanery : this.deaneryRepository.getAllDeaneries()) {
            deaneries.add(new DeaneryModel(deanery));
        }
        if (!deaneries.isEmpty()) {
            return ResponseEntity.ok(deaneries);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deaneries not found");
    }

    @GetMapping(produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /professors?lastname=Lastname
     */
    @ResponseBody
    public ResponseEntity<Object> getStudentByLastname(@RequestParam(value = "lastname") String label) {
        List<DeaneryModel> deaneries = new ArrayList<>();
        for (Deanery deanery : this.deaneryRepository.getDeaneriesByLabel(label)) {
            deaneries.add(new DeaneryModel(deanery));
        }
        if (!deaneries.isEmpty()) {
            return ResponseEntity.ok(deaneries);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deaneries by name " + label + " not found");
    }

    @GetMapping(value = "/{id}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /professors/2
     */
    @ResponseBody
    public ResponseEntity<Object> getStudent(@PathVariable long id) {
        Deanery deanery = this.deaneryRepository.getDeanery(id);
        if (deanery != null) {
            return ResponseEntity.ok(new DeaneryModel(deanery));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deanery by id " + id + " not found");
    }

}
