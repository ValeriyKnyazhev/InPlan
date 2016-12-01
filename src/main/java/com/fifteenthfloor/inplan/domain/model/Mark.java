package com.fifteenthfloor.inplan.domain.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
@Document(collection = "accounts")
@EqualsAndHashCode
@NoArgsConstructor
@TypeAlias("account")
public class Mark {

    private static final int MAX_VALUE = 10;

    private static final int MIN_VALUE = 0;

    @Id
    private long id;

    private int value;

    private long student;

    private long professor;

    private long course;

    private Date date;

    private String description;
    @Version
    private int version;

    public Mark(int value, long student, long professor, long course, Date date, String description) {
        setStudent(student);
        setProfessor(professor);
        setCourse(course);
        setValue(value);
        setDate(date);
        setDescription(description);
    }

    public long getStudent() {
        return this.student;
    }

    public void setStudent(long student) {
        this.student = student;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) throws NotValidMarkException{
        if (value >= MIN_VALUE || value <= MAX_VALUE) {
            this.value = value;
        } else {
            throw new NotValidMarkException("Not correct value.");
        }
    }

    public long getProfessor() {
        return this.professor;
    }

    public void setProfessor(long professor) {
        this.professor = professor;
    }

    public long getCourse() {
        return this.course;
    }

    public void setCourse(long course) {
        this.course = course;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
