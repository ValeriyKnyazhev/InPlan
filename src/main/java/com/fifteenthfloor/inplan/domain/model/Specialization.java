package com.fifteenthfloor.inplan.domain.model;

import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
@NoArgsConstructor
public class Specialization {

    private static final int MIN_COURSES_COUNT = 0;

    private String label;

    private int minExtraCoursesCount;

    private ArrayList<Course> requiredCourses;

    public Specialization(String label, int coursesCount, ArrayList<Course> requiredCourses) {
        setLabel(label);
        setMinExtraCoursesCount(coursesCount);
        setRequiredCourses(requiredCourses);
    }

    public String getLabel() {
        return this.label;
    }

    public int getMinExtraCoursesCount() {
        return this.minExtraCoursesCount;
    }

    public ArrayList<Course> getRequiredCourses() {
        return this.requiredCourses;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setMinExtraCoursesCount(int coursesCount) throws NotValidCoursesCountException {
        if (coursesCount >= MIN_COURSES_COUNT) {
            this.minExtraCoursesCount = coursesCount;
        } else {
            throw new NotValidCoursesCountException("Not correct minimal count of extra courses.");
        }
    }

    public void setRequiredCourses(ArrayList<Course> requiredCourses) {
        this.requiredCourses = requiredCourses;
    }

}
