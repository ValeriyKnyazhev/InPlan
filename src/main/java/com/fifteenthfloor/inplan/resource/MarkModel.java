package com.fifteenthfloor.inplan.resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

    private Date date;

    private String description;

    @JsonCreator
    public MarkModel(@JsonProperty("value") int value, @JsonProperty("student") long student,
                     @JsonProperty("professor") long professor, @JsonProperty("course") long course,
                     @JsonProperty("date") Date date, @JsonProperty("description") String description) {
        this.value = value;
        this.student = student;
        this.professor = professor;
        this.course = course;
        this.date = date;
        this.description = description;
    }

}
