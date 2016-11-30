package com.fifteenthfloor.inplan.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
@Data
@NoArgsConstructor
abstract class User {

    private static long currentId = 1;
    private long id;
    private String login;
    private String passwordHash;
    private String email;

    public User(String login, String email, String passwordHash) {
        this.id = currentId++;
        setEmail(email);
        setLogin(login);
        setPasswordHash(passwordHash);
    }

    public long getId() {
        return this.id;
    }

}
