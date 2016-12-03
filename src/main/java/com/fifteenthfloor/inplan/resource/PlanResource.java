package com.fifteenthfloor.inplan.resource;

import com.fifteenthfloor.inplan.domain.model.Plan;
import com.fifteenthfloor.inplan.domain.model.PlanRepository;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Valeriy Knyazhev
 */
@RestController
@RequestMapping(value = "/plans")
public class PlanResource {

    private PlanRepository planRepository;

    public PlanResource(@NonNull PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @GetMapping(value = "/id/{id}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /plans/id/11
     */
    @ResponseBody
    public ResponseEntity<Object> getPlan(@PathVariable long id) {
        Plan plan = this.planRepository.getPlan(id);
        if (plan != null) {
            return ResponseEntity.ok(plan);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plan by id " + id + " not found");
    }

    @GetMapping(value = "/all/bycourse/{course}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /plans/all/bycourse/11
     */
    @ResponseBody
    public ResponseEntity<Object> getPlansByCourse(@PathVariable long course) {
        ArrayList<Long> plans = this.planRepository.getPlansByCourse(course);
        if (!plans.isEmpty()) {
            return ResponseEntity.ok(plans);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plans by course " + course + " not found");
    }

    @GetMapping(value = "/courses/id/{id}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /plans/courses/id/11
     */
    @ResponseBody
    public ResponseEntity<Object> getCourses(@PathVariable long id) {
        Plan plan = this.planRepository.getPlan(id);
        if (plan != null) {
            return ResponseEntity.ok(plan.getCourses());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plan by id " + id + " not found");
    }

    @GetMapping(value = "/specialization/id/{specialization}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /plans/specialization/id/2
     */
    @ResponseBody
    public ResponseEntity<Object> getIdPlansBySpecialization(@PathVariable long specialization) {
        ArrayList<Long> plans = new ArrayList<>();
        for (Plan plan : this.planRepository.getPlansBySpecialization(specialization)) {
            if (plan.getSpecialization() == specialization) {
                plans.add(plan.getId());
            }
        }
        if (!plans.isEmpty()) {
            return ResponseEntity.ok(plans);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plans by specialization " + specialization + " not found");
    }

}
