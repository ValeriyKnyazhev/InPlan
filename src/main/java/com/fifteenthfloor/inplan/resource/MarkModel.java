package com.fifteenthfloor.inplan.resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Valeriy Knyazhev
 */
@Data
@NoArgsConstructor
public class MarkModel {

    private int value;

    private long student;

    private long professor;

    private long course;

    private String description;

    @JsonCreator
    public MarkModel(@JsonProperty("value") int value, @JsonProperty("student") long student,
                     @JsonProperty("professor") long professor, @JsonProperty("course") long course,
                     @JsonProperty("description") String description) {
        this.value = value;
        this.student = student;
        this.professor = professor;
        this.course = course;
        this.description = description;
    }

}
