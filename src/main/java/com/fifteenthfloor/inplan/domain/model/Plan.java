package com.fifteenthfloor.inplan.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
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

    private Set<Long> courses;

    private long specialization;

    public Plan(long id, long specialization) {
        this.courses = new HashSet<>();
        setId(id);
        setSpecialization(specialization);
    }

    public Plan(long id, Long[] courses, long specialization) {
        this.courses = new HashSet<Long>(Arrays.asList(courses));
        setId(id);
        setSpecialization(specialization);
    }

    public void addCourse(long course) {
        this.courses.add(course);
    }

    void removeCourse(long course) {
        this.courses.remove(course);
    }

}
