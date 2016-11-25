package com.fifteenthfloor.inplan.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
@NoArgsConstructor
public class Mark {

    private static final int MAX_VALUE = 10;

    private static final int MIN_VALUE = 0;

    private int value;

    private long student;

    private long professor;

    private Date date;

    private String description;

    public Mark(int value, long student, long professor, Date date, String description) {
        setStudent(student);
        setProfessor(professor);
        setValue(value);
        setDate(date);
        setDescription(description);
    }

    public long getStudent() {
        return this.student;
    }

    public int getValue() {
        return this.value;
    }

    public long getProfessor() {
        return this.professor;
    }

    public Date getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setStudent(long student) {
        this.student = student;
    }

    public void setProfessor(long professor) {
        this.professor = professor;
    }

    public void setValue(int value) throws NotValidMarkException{
        if (value >= MIN_VALUE || value <= MAX_VALUE) {
            this.value = value;
        } else {
            throw new NotValidMarkException("Not correct value.");
        }
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
