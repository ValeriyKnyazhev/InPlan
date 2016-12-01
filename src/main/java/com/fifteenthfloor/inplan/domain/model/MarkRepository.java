package com.fifteenthfloor.inplan.domain.model;

import com.fifteenthfloor.inplan.resource.MarkModel;

import java.util.ArrayList;

/**
 * @author Valeriy Knyazhev
 */
public interface MarkRepository {

    public void create(MarkModel model);

    public ArrayList<MarkModel> findByStudent(long student);

    public ArrayList<MarkModel> findByProfessor(long professor);

    public ArrayList<MarkModel> findByCourse(long course);

    public MarkModel find(long id);

    public void update(long id, MarkModel model);

    public void remove(long id);

}
