package com.fifteenthfloor.inplan.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
@NoArgsConstructor
public class Mark {

    private static final int MAX_VALUE = 10;

    private static final int MIN_VALUE = 0;

    private int value;

    private Student student;

    public Mark(int value, Student student) {
        setStudent(student);
        setValue(value);
    }

    public Student getStudent() {
        return this.student;
    }

    public int getValue() {
        return this.value;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setValue(int value) throws NotValidMarkException{
        if (value >= MIN_VALUE || value <= MAX_VALUE) {
            this.value = value;
        } else {
            throw new NotValidMarkException("Not correct value.");
        }
    }

}
