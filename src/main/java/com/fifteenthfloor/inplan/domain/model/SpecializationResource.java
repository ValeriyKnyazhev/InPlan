package com.fifteenthfloor.inplan.domain.model;

import java.util.ArrayList;

/**
 * @author Valeriy Knyazhev
 */
public interface SpecializationResource {

    ArrayList<Specialization> getAllSpecializations();

    ArrayList<Specialization> getSpecializationByLabel(String label);

    Specialization getSpecialization(long id);

    void createSpecialization(Specialization specialization);

}
