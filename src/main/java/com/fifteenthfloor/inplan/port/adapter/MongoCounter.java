package com.fifteenthfloor.inplan.port.adapter;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Valeriy Knyazhev
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Document(collection = "sequences")
public class MongoCounter {


    @Id
    private String collectionName;

    private long seq;

    public MongoCounter(String collectionName) {
        this(collectionName, 1L);
    }

    protected long seq() {
        return this.seq;
    }
}
