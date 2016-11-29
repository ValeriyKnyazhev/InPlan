package com.fifteenthfloor.inplan.domain.model;

import lombok.*;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
@Data
@NoArgsConstructor
abstract class User {

    private long id;

    private String login;

    private String passwordHash;

    private String email;

    private static long currentId = 1;

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
