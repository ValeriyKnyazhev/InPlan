package com.fifteenthfloor.inplan.port.adapter;

import com.fifteenthfloor.inplan.domain.model.Mark;
import com.fifteenthfloor.inplan.domain.model.MarkRepository;
import com.fifteenthfloor.inplan.resource.MarkModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @author Valeriy Knyazhev
 */
@Repository
public class MongoMarkRepository implements MarkRepository {

    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    private MongoCounterService mongoCounterService;

    public MongoMarkRepository(MongoOperations mongoOperations, MongoCounterService mongoCounterService) {
        this.mongoOperations = mongoOperations;
        this.mongoCounterService = mongoCounterService;
    }

    @Override
    public void create(MarkModel model) {
        long id = this.mongoCounterService.nextId("marks");
        try {
            this.mongoOperations.insert(new Mark(id, model));
        } catch (DuplicateKeyException e) {
            throw new MarkAlreayExistsException("Mark with id " + id + " already exists.");
        }
    }

    @Override
    public ArrayList<MarkModel> findByStudent(long student) {
        Query query = new Query();
        query.addCriteria(where("student").is(student));
        List<Mark> marks = this.mongoOperations.find(query, Mark.class);
        return new ArrayList<>(marks.stream().map(Mark::getModel).collect(Collectors.toList()));
    }

    @Override
    public ArrayList<MarkModel> findByProfessor(long professor) {
        Query query = new Query();
        query.addCriteria(where("professor").is(professor));
        List<Mark> marks = this.mongoOperations.find(query, Mark.class);
        return new ArrayList<>(marks.stream().map(Mark::getModel).collect(Collectors.toList()));
    }

    @Override
    public ArrayList<MarkModel> findByCourse(long course) {
        Query query = new Query();
        query.addCriteria(where("course").is(course));
        List<Mark> marks = this.mongoOperations.find(query, Mark.class);
        return new ArrayList<>(marks.stream().map(Mark::getModel).collect(Collectors.toList()));
    }

    @Override
    public MarkModel find(long id) {
        return this.mongoOperations.findById(id, Mark.class).getModel();
    }

    @Override
    public void update(long id, MarkModel model) {
        try {
            Mark storedMark = this.mongoOperations.findById(id, Mark.class);
            if (storedMark != null) {
                storedMark.setValue(model.getValue());
                storedMark.setStudent(model.getStudent());
                storedMark.setProfessor(model.getProfessor());
                storedMark.setCourse(model.getCourse());
                storedMark.setDescription(model.getDescription());
            }
            this.mongoOperations.save(storedMark);
        } catch (Exception e) {
            throw new MarkNotFoundException("Mark with id " + id + " not found.");
        }
    }

    @Override
    public void remove(long id) {
        Mark storedMark = this.mongoOperations.findById(id, Mark.class);
        if (storedMark != null) {
            this.mongoOperations.remove(storedMark);
        } else {
            throw new MarkNotFoundException("Mark with id " + id + " not found.");
        }
    }

}
