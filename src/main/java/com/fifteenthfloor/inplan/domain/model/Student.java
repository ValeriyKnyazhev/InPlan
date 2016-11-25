package com.fifteenthfloor.inplan.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Student extends User {

    private String firstname;

    private String middlename;

    private String lastname;

    private Sex sex = Sex.Other;

    private Date birthday;

    private int credits;

    private long plan;

    public Student(String firstname, String middlename, String lastname, String login, String email, String passwordHash,
                   Sex sex, Date birthday, int credits) {
        super(login, email, passwordHash);
        setFirstname(firstname);
        setMiddlename(middlename);
        setLastname(lastname);
        setSex(sex);
        setBirthday(birthday);
        setCredits(credits);
        setPlan(getId());
    }

}
