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

    private Plan plan;

}
