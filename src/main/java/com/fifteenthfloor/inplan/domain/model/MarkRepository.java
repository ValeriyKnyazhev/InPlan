package com.fifteenthfloor.inplan.domain.model;

import com.fifteenthfloor.inplan.resource.MarkModel;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Valeriy Knyazhev
 */
public interface MarkRepository {

    public void create(MarkModel model);

    public ArrayList<MarkModel> findByStudent(long student);

    public ArrayList<MarkModel> findByProfesor(long professor);

    public ArrayList<MarkModel> findByCourse(long course);

    public ArrayList<MarkModel> findByDate(Date firstDate, Date secondDate);

    public MarkModel find(long id);

    public void update(MarkModel model);

    public void remove(long id);

}
