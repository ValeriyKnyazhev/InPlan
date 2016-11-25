package com.fifteenthfloor.inplan.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Professor extends User {

    private String firstname;

    private String middlename;

    private String lastname;

    public Professor(String firstname, String middlename, String lastname, String login, String email, String passwordHash) {
        super(login, email, passwordHash);
        setFirstname(firstname);
        setMiddlename(middlename);
        setLastname(lastname);
    }

}
