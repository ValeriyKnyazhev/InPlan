package com.fifteenthfloor.inplan.domain.model;

import java.util.Set;

/**
 * @author Valeriy Knyazhev
 */
public interface PlanRepository {

    Plan getPlan(long id);

    Set<Long> getPlanCourses(long id);

    void createPlan(Plan plan);

}
