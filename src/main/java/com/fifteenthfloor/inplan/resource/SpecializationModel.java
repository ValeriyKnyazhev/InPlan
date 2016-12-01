package com.fifteenthfloor.inplan.resource;

import com.fifteenthfloor.inplan.domain.model.Specialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @author Valeriy Knyazhev
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class SpecializationModel {

    private long id;

    private String label;

    private ArrayList<Long> requiredCourses;

    public SpecializationModel(Specialization specialization) {
        setId(specialization.getId());
        setLabel(specialization.getLabel());
        setRequiredCourses(specialization.getRequiredCourses());
    }

}
