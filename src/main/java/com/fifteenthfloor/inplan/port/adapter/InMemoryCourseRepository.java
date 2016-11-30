package com.fifteenthfloor.inplan.port.adapter;

import com.fifteenthfloor.inplan.domain.model.Course;
import com.fifteenthfloor.inplan.domain.model.CourseRepository;
import com.fifteenthfloor.inplan.domain.model.StudyArea;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Valeriy Knyazhev
 */
@Repository
public class InMemoryCourseRepository implements CourseRepository {

    private List<Course> courses = new ArrayList<>();

    public InMemoryCourseRepository() {
        loadCourses();
    }

    private void loadCourses() {
        createCourse(new Course(1, "Math Analysis", 300, null, null,
                StudyArea.Mathematics, new Long[]{}, new Long[]{5L}));
        createCourse(new Course(2, "Fundamental Physics", 300, null, null,
                StudyArea.Physics, new Long[]{}, new Long[]{3L}));
        createCourse(new Course(3, "Theoretical Physics", 1000, null, null,
                StudyArea.Physics, new Long[]{2L}, new Long[]{3L}));
        createCourse(new Course(4, "Theory of function with complex variables", 800, null,
                null, StudyArea.Mathematics, new Long[]{1L}, new Long[]{5L}));
        createCourse(new Course(5, "Chemistry", 500, null, null,
                StudyArea.Chemistry, new Long[]{}, new Long[]{4L}));
        createCourse(new Course(6, "English: part 1", 200, null, null,
                StudyArea.Linguistics, new Long[]{}, new Long[]{6L}));
        createCourse(new Course(7, "English: part 2", 400, null, null,
                StudyArea.Linguistics, new Long[]{6L}, new Long[]{6L}));
        createCourse(new Course(8, "English: part 3", 1000, null, null,
                StudyArea.Linguistics, new Long[]{6L, 7L}, new Long[]{6L}));
        createCourse(new Course(9, "Biology", 600, null, null,
                StudyArea.Biology, new Long[]{}, new Long[]{4L}));
        createCourse(new Course(10, "Anatomy", 200, null, null,
                StudyArea.Biology, new Long[]{9L}, new Long[]{4L}));
    }

    @Override
    public ArrayList<Course> getAllCourses() {
        return new ArrayList<Course>(this.courses);
    }

    @Override
    public ArrayList<Course> getCoursesByLabel(String label) {
        ArrayList<Course> courses = new ArrayList<>();
        for (Course course : this.courses) {
            if (course.getLabel().equals(label)) {
                courses.add(course);
            }
        }
        return courses;
    }

    @Override
    public ArrayList<Course> getCoursesByStudyArea(StudyArea studyArea) {
        ArrayList<Course> courses = new ArrayList<>();
        for (Course course : this.courses) {
            if (course.getStudyArea().equals(studyArea)) {
                courses.add(course);
            }
        }
        return courses;
    }

    @Override
    public ArrayList<Course> getCoursesByProfessor(long professor) {
        ArrayList<Course> courses = new ArrayList<>();
        for (Course course : this.courses) {
            if (course.getProfessors().contains(professor)) {
                courses.add(course);
            }
        }
        return courses;
    }

    @Override
    public ArrayList<Course> getCoursesByMaxPrice(int creditsPrice) {
        ArrayList<Course> courses = new ArrayList<>();
        for (Course course : this.courses) {
            if (course.getCreditsPrice() <= creditsPrice) {
                courses.add(course);
            }
        }
        return courses;
    }

    @Override
    public Course getCourse(long id) {
        return this.courses.stream().filter(c -> id == c.getId()).findFirst().orElse(null);
    }

    @Override
    public void createCourse(Course course) {
        if (getCourse(course.getId()) == null) {
            this.courses.add(course);
        }
    }
}
