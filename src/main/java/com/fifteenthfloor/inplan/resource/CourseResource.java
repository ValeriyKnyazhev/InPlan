package com.fifteenthfloor.inplan.resource;

import com.fifteenthfloor.inplan.domain.model.Course;
import com.fifteenthfloor.inplan.domain.model.CourseRepository;
import com.fifteenthfloor.inplan.domain.model.StudyArea;
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
@RequestMapping(value = "/courses")
public class CourseResource {

    private CourseRepository courseRepository;

    public CourseResource(@NonNull CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping(value = "/all", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /courses/all
     */
    @ResponseBody
    public ResponseEntity<Object> getAllCourses() {
        List<CourseModel> courses = new ArrayList<>();
        for (Course course : this.courseRepository.getAllCourses()) {
            courses.add(new CourseModel(course));
        }
        if (!courses.isEmpty()) {
            return ResponseEntity.ok(courses);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Courses not found");
    }

    @GetMapping(value = "/all/id", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /courses/all/id
     */
    @ResponseBody
    public ResponseEntity<Object> getAllIdCourses() {
        List<Long> courses = new ArrayList<>();
        for (Course course : this.courseRepository.getAllCourses()) {
            courses.add(course.getId());
        }
        if (!courses.isEmpty()) {
            return ResponseEntity.ok(courses);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Courses not found");
    }

    @GetMapping(value = "/label/{label}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /courses/label/Label
     */
    @ResponseBody
    public ResponseEntity<Object> getCoursesByLabel(@PathVariable String label) {
        List<CourseModel> courses = new ArrayList<>();
        for (Course course : this.courseRepository.getCoursesByLabel(label)) {
            courses.add(new CourseModel(course));
        }
        if (!courses.isEmpty()) {
            return ResponseEntity.ok(courses);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Courses by label " + label + " not found");
    }

    @GetMapping(value = "/label/id/{label}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /courses/label/id/Label
     */
    @ResponseBody
    public ResponseEntity<Object> getIdCoursesByLabel(@PathVariable String label) {
        List<Long> courses = new ArrayList<>();
        for (Course course : this.courseRepository.getCoursesByLabel(label)) {
            courses.add(course.getId());
        }
        if (!courses.isEmpty()) {
            return ResponseEntity.ok(courses);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Courses by label " + label + " not found");
    }

    @GetMapping(value = "/studyArea/{studyArea}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /courses/studyArea/StudyArea
     */
    @ResponseBody
    public ResponseEntity<Object> getCoursesByStudyArea(@PathVariable String studyArea) {
        List<CourseModel> courses = new ArrayList<>();
        List<Course> originalCourses;
        try {
            originalCourses = this.courseRepository.getCoursesByStudyArea(StudyArea.valueOf(studyArea));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("StudyArea " + studyArea + " not found");
        }
        for (Course course : originalCourses) {
            courses.add(new CourseModel(course));
        }
        if (!courses.isEmpty()) {
            return ResponseEntity.ok(courses);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Courses by studyArea " + studyArea + " not found");
    }

    @GetMapping(value = "/studyArea/id/{studyArea}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /courses/studyArea/id/StudyArea
     */
    @ResponseBody
    public ResponseEntity<Object> getIdCoursesByStudyArea(@PathVariable String studyArea) {
        List<Long> courses = new ArrayList<>();
        List<Course> originalCourses;
        try {
            originalCourses = this.courseRepository.getCoursesByStudyArea(StudyArea.valueOf(studyArea));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("StudyArea " + studyArea + " not found");
        }
        for (Course course : originalCourses) {
            courses.add(course.getId());
        }
        if (!courses.isEmpty()) {
            return ResponseEntity.ok(courses);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Courses by studyArea " + studyArea + " not found");
    }

    @GetMapping(value = "professor/{professor}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /courses/professor/1
     */
    @ResponseBody
    public ResponseEntity<Object> getCoursesByProfessor(@PathVariable long professor) {
        List<CourseModel> courses = new ArrayList<>();
        for (Course course : this.courseRepository.getCoursesByProfessor(professor)) {
            courses.add(new CourseModel(course));
        }
        if (!courses.isEmpty()) {
            return ResponseEntity.ok(courses);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Courses by professor " + professor + " not found");
    }

    @GetMapping(value = "/professor/id/{professor}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /courses/professor/id/1
     */
    @ResponseBody
    public ResponseEntity<Object> getIdCoursesByLabel(@PathVariable long professor) {
        List<Long> courses = new ArrayList<>();
        for (Course course : this.courseRepository.getCoursesByProfessor(professor)) {
            courses.add(course.getId());
        }
        if (!courses.isEmpty()) {
            return ResponseEntity.ok(courses);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Courses by professor " + professor + " not found");
    }

    @GetMapping(value = "/id/{id}", produces = {APPLICATION_JSON_UTF8_VALUE})
    /*
    GET /courses/id/3
     */
    @ResponseBody
    public ResponseEntity<Object> getStudent(@PathVariable long id) {
        Course course = this.courseRepository.getCourse(id);
        if (course != null) {
            return ResponseEntity.ok(new CourseModel(course));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course by id " + id + " not found");
    }

}
