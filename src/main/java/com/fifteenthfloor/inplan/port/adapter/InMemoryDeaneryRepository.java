package com.fifteenthfloor.inplan.port.adapter;

import com.fifteenthfloor.inplan.domain.model.Deanery;
import com.fifteenthfloor.inplan.domain.model.DeaneryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Valeriy Knyazhev
 */
@Repository
public class InMemoryDeaneryRepository implements DeaneryRepository {

    private List<Deanery> deaneries = new ArrayList<>();

    public InMemoryDeaneryRepository() {
        loadDeaneries();
    }

    private void loadDeaneries() {
        this.deaneries.add(new Deanery("FIVT", "fivt-dekanat", "fivt-dekanat@phystech.edu", "09798d0y4985y45"));
        this.deaneries.add(new Deanery("FUPM", "fupm-dekanat", "fupm-dekanat@phystech.edu", "u5o41iu5v9854"));
    }

    @Override
    public ArrayList<Deanery> getAllDeaneries() {
        return new ArrayList<>(this.deaneries);
    }

    @Override
    public ArrayList<Deanery> getDeaneriesByLabel(String label) {
        ArrayList<Deanery> deaneries = new ArrayList<>();
        for (Deanery deanery : this.deaneries) {
            if (deanery.getLabel().equals(label)) {
                deaneries.add(deanery);
            }
        }
        return deaneries;
    }

    @Override
    public Deanery getDeanery(long id) {
        return this.deaneries.stream().filter(st -> id == st.getId()).findFirst().orElse(null);
    }

}
