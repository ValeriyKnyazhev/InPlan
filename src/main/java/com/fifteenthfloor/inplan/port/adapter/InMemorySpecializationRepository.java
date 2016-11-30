package com.fifteenthfloor.inplan.port.adapter;

import com.fifteenthfloor.inplan.domain.model.Specialization;
import com.fifteenthfloor.inplan.domain.model.SpecializationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Valeriy Knyazhev
 */
public class InMemorySpecializationRepository implements SpecializationRepository {

    private List<Specialization> specializations = new ArrayList<>();

    public InMemorySpecializationRepository() {
        loadSpecializations();
    }

    private void loadSpecializations() {
        createSpecialization(new Specialization(1, "Applied Methematics", 3, new ArrayList<>(Arrays.asList(new Long[]{1L, 4L, 6L}))));
        createSpecialization(new Specialization(2, "Applied Physics", 3, new ArrayList<>(Arrays.asList(new Long[]{1L, 4L, 6L}))));
        createSpecialization(new Specialization(3, "ranslator\n", 3, new ArrayList<>(Arrays.asList(new Long[]{1L, 4L, 6L}))));
        createSpecialization(new Specialization(4, "Medicine", 3, new ArrayList<>(Arrays.asList(new Long[]{1L, 4L, 6L}))));
    }

    @Override
    public ArrayList<Specialization> getAllSpecializations() {
        return new ArrayList<>(this.specializations);
    }

    @Override
    public ArrayList<Specialization> getSpecializationByLabel(String label) {
        ArrayList<Specialization> specializations = new ArrayList<>();
        for (Specialization specialization : this.specializations) {
            if (specialization.getLabel().equals(label)) {
                specializations.add(specialization);
            }
        }
        return specializations;
    }

    @Override
    public Specialization getSpecialization(long id) {
        return this.specializations.stream().filter(sp -> id == sp.getId()).findFirst().orElse(null);
    }

    @Override
    public void createSpecialization(Specialization specialization) {
        if (getSpecialization(specialization.getId()) == null) {
            this.specializations.add(specialization);
        }
    }

}
