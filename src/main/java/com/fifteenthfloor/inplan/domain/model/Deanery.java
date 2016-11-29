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
public class Deanery extends User {

    private String label;

    public Deanery(String label, String login, String email, String passwordHash) {
        super(login, email, passwordHash);
        setLabel(label);
    }


}
