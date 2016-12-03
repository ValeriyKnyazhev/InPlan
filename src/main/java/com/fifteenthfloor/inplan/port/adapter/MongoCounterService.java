package com.fifteenthfloor.inplan.port.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @author Valeriy Knyazhev
 */
@Service
public class MongoCounterService {

    @Autowired
    private MongoOperations mongoOperations;

    long nextId(String collectionName) {
        Query query = new Query().addCriteria(where("_id").is(collectionName));
        FindAndModifyOptions options = new FindAndModifyOptions().upsert(true).returnNew(true);
        MongoCounter counter = this.mongoOperations
                .findAndModify(query, new Update().inc("seq", 1), options, MongoCounter.class);
        return counter.seq();
    }
}
