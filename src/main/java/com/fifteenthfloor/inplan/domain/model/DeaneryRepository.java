package com.fifteenthfloor.inplan.domain.model;

import java.util.ArrayList;

/**
 * @author Valeriy Knyazhev
 */
public interface DeaneryRepository {

    ArrayList<Deanery> getAllDeaneries();

    ArrayList<Deanery> getDeaneriesByLabel(String label);

    Deanery getDeanery(long id);

}
