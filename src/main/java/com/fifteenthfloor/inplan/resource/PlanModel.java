package com.fifteenthfloor.inplan.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @author Valeriy Knyazhev
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class PlanModel {

    private long id;

    private Set<Long> courses;

}
