package com.fifteenthfloor.inplan.domain.model;

import java.util.ArrayList;

/**
 * @author Valeriy Knyazhev
 */
public interface CourseRepository {

    ArrayList<Course> getAllCourses();

    ArrayList<Course> getCoursesByLabel(String label);

    ArrayList<Course> getCoursesByStudyArea(StudyArea studyArea);

    ArrayList<Course> getCoursesByProfessor(long professor);

    ArrayList<Course> getCoursesByMaxPrice(int creditsPrice);

    Course getCourse(long id);

    void createCourse(Course course);

}
