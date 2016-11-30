package com.fifteenthfloor.inplan.resource;

import com.fifteenthfloor.inplan.domain.model.Course;
import com.fifteenthfloor.inplan.domain.model.StudyArea;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @author Valeriy Knyazhev
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class CourseModel {

    private long id;

    private String label;

    private int creditsPrice;

    private StudyArea studyArea;

    private ArrayList<Long> requiredCompletedCourses;

    private ArrayList<Long> professors;

    public CourseModel(Course course) {
        setId(course.getId());
        setLabel(course.getLabel());
        setCreditsPrice(course.getCreditsPrice());
        setStudyArea(course.getStudyArea());
        setRequiredCompletedCourses(course.getRequiredCompletedCourses());
        setProfessors(course.getProfessors());
    }

}
