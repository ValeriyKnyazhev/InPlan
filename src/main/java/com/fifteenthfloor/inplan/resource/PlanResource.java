package com.fifteenthfloor.inplan.resource;

import com.fifteenthfloor.inplan.domain.model.Plan;
import com.fifteenthfloor.inplan.domain.model.PlanRepository;
import com.fifteenthfloor.inplan.domain.model.Student;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping(value = "/{id}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /plans/1
     */
    @ResponseBody
    public ResponseEntity<Object> getPlan(@PathVariable long id) {
        Plan plan = this.planRepository.getPlan(id);
        if (plan != null) {
            return ResponseEntity.ok(plan);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plan by id " + id + " not found");
    }

    @GetMapping(value = "/id", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /plans/courses/{id}
     */
    @ResponseBody
    public ResponseEntity<Object> getIdStudentByLastname(@PathVariable long id) {
        List<Long> courses = new ArrayList<>();
        Plan plan = this.planRepository.getPlan(id);
        if (plan != null) {
            return ResponseEntity.ok(plan.getCourses());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("plan by id " + id + " not found");
    }

}
