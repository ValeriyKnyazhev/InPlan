package com.fifteenthfloor.inplan.domain.model;

import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
@NoArgsConstructor
public class Specialization {

    private static final int MIN_COURSES_COUNT = 0;

    private long id;

    private String label;

    private int minExtraCoursesCount;

    private ArrayList<Long> requiredCourses;

    public Specialization(long id, String label, int coursesCount, ArrayList<Long> requiredCourses) {
        setId(id);
        setLabel(label);
        setMinExtraCoursesCount(coursesCount);
        setRequiredCourses(requiredCourses);
    }

    public long getId() {
        return this.id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getMinExtraCoursesCount() {
        return this.minExtraCoursesCount;
    }

    public void setMinExtraCoursesCount(int coursesCount) throws NotValidCoursesCountException {
        if (coursesCount >= MIN_COURSES_COUNT) {
            this.minExtraCoursesCount = coursesCount;
        } else {
            throw new NotValidCoursesCountException("Not correct minimal count of extra courses.");
        }
    }

    public ArrayList<Long> getRequiredCourses() {
        return this.requiredCourses;
    }

    public void setRequiredCourses(ArrayList<Long> requiredCourses) {
        this.requiredCourses = requiredCourses;
    }

}
