package com.fifteenthfloor.inplan.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Plan {

    private long id;

    private Set<Course> courses;

    Plan(long id) {
        courses = new HashSet<>();
        setId(id);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    void removeCourse(Course course) {
        this.courses.remove(course);
    }

}
