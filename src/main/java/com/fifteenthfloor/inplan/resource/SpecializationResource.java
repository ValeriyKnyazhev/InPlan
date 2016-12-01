package com.fifteenthfloor.inplan.resource;

import com.fifteenthfloor.inplan.domain.model.Specialization;
import com.fifteenthfloor.inplan.domain.model.SpecializationRepository;
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
@RequestMapping(value = "/specializations")
public class SpecializationResource {

    private SpecializationRepository specializationRepository;

    public SpecializationResource(@NonNull SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    @GetMapping(value = "/all", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /specializations/all
     */
    @ResponseBody
    public ResponseEntity<Object> getAllSpecializations() {
        List<SpecializationModel> specializations = new ArrayList<>();
        for (Specialization specialization : this.specializationRepository.getAllSpecializations()) {
            specializations.add(new SpecializationModel(specialization));
        }
        if (!specializations.isEmpty()) {
            return ResponseEntity.ok(specializations);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Specializations not found");
    }

    @GetMapping(value = "/all/id", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /specializations/all/id
     */
    @ResponseBody
    public ResponseEntity<Object> getAllIdSpecializations() {
        List<Long> specializations = new ArrayList<>();
        for (Specialization spec : this.specializationRepository.getAllSpecializations()) {
            specializations.add(spec.getId());
        }
        if (!specializations.isEmpty()) {
            return ResponseEntity.ok(specializations);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Specializations not found");
    }

    @GetMapping(value = "/label/{label}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /specializations/label/Label
     */
    @ResponseBody
    public ResponseEntity<Object> getSpecializationsByLabel(@PathVariable String label) {
        List<SpecializationModel> specializations = new ArrayList<>();
        for (Specialization specialization : this.specializationRepository.getSpecializationByLabel(label)) {
            specializations.add(new SpecializationModel(specialization));
        }
        if (!specializations.isEmpty()) {
            return ResponseEntity.ok(specializations);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Specializations by label " + label + " not found");
    }

    @GetMapping(value = "/label/id/{label}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /specializations/label/id/Label
     */
    @ResponseBody
    public ResponseEntity<Object> getIdSpecializationsByLabel(@PathVariable String label) {
        List<Long> specializations = new ArrayList<>();
        for (Specialization specialization : this.specializationRepository.getSpecializationByLabel(label)) {
            specializations.add(specialization.getId());
        }
        if (!specializations.isEmpty()) {
            return ResponseEntity.ok(specializations);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Specializations by label " + label + " not found");
    }

    @GetMapping(value = "/id/{id}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /specializations/id/2
     */
    @ResponseBody
    public ResponseEntity<Object> getSpecialization(@PathVariable long id) {
        Specialization specialization = this.specializationRepository.getSpecialization(id);
        if (specialization != null) {
            return ResponseEntity.ok(new SpecializationModel(specialization));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Specialization by id " + id + " not found");
    }

}
