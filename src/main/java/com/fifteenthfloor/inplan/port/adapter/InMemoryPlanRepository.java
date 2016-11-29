package com.fifteenthfloor.inplan.port.adapter;

import com.fifteenthfloor.inplan.domain.model.Plan;
import com.fifteenthfloor.inplan.domain.model.PlanRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Valeriy Knyazhev
 */
@Repository
public class InMemoryPlanRepository implements PlanRepository {

    private List<Plan> plans = new ArrayList<>();

    public InMemoryPlanRepository() {
        loadPlans();
    }

    private void loadPlans() {

    }

    @Override
    public Plan getPlan(long id) {
        return this.plans.stream().filter(plan -> id == plan.getId()).findFirst().orElse(null);
    }

    @Override
    public Set<Long> getPlanCourses(long id) {
        Plan plan = this.plans.stream().filter(p -> id == p.getId()).findFirst().orElse(null);
        if (plan != null) {
            return plan.getCourses();
        } else {
            return null;
        }
    }

    @Override
    public void createPlan(Plan plan) {
        if (getPlan(plan.getId()) == null) {
            this.plans.add(plan);
        }
    }
}
