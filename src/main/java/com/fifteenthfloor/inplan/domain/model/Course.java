package com.fifteenthfloor.inplan.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Course {

    private long id;

    private String label;

    private int creditsPrice;

    private ArrayList<String> description;

    private ArrayList<String> schedule;

    private StudyArea studyArea;

    private ArrayList<Long> requiredCompletedCourses;

    private ArrayList<Long> professors;

    public Course(long id, String label, int creditsPrice, ArrayList<String> description, ArrayList<String> schedule,
                  StudyArea studyArea, Long[] requiredCompletedCourses, Long[] professors) {
        setId(id);
        setLabel(label);
        setCreditsPrice(creditsPrice);
        setDescription(description);
        setSchedule(schedule);
        setStudyArea(studyArea);
        setRequiredCompletedCourses(new ArrayList<Long>(Arrays.asList(requiredCompletedCourses)));
        setProfessors(new ArrayList<Long>(Arrays.asList(professors)));
    }

}
