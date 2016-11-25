package com.fifteenthfloor.inplan.resource;

import com.fifteenthfloor.inplan.domain.model.Sex;
import com.fifteenthfloor.inplan.domain.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Valeriy Knyazhev
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class StudentModel {

    private long id;

    private String firstname;

    private String middlename;

    private String lastname;

    private Sex sex = Sex.Other;

    private String login;

    private String email;

    public StudentModel(Student student) {
        setId(student.getId());
        setFirstname(student.getFirstname());
        setMiddlename(student.getMiddlename());
        setLastname(student.getLastname());
        setSex(student.getSex());
        setLogin(student.getLogin());
        setEmail(student.getEmail());
    }

}
