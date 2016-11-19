package com.fifteenthfloor.inplan.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Course {

    private String label;

    private int creditsPrice;

    private ArrayList<String> description;

    private ArrayList<String> schedule;

    private StudyArea studyArea;

    private ArrayList<Course> requiredCompletedCourses;

    private ArrayList<Professor> professors;

    private ArrayList<Task> tasks;

}
