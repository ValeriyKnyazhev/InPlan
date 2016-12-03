package com.fifteenthfloor.inplan.domain.model;

import java.util.ArrayList;
import java.util.Set;

/**
 * @author Valeriy Knyazhev
 */
public interface PlanRepository {

    Plan getPlan(long id);

    ArrayList<Plan> getPlansBySpecialization(long specialization);

    Set<Long> getPlanCourses(long id);


    ArrayList<Long> getPlansByCourse(long course);

    void createPlan(Plan plan);

}
