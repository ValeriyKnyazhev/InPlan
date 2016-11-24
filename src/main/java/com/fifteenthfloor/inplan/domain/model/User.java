package com.fifteenthfloor.inplan.domain.model;

import lombok.*;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
@Data
@NoArgsConstructor
abstract class User {

    private long id;

    @Getter(AccessLevel.PUBLIC)
    private String login;

    @Getter(AccessLevel.PROTECTED)
    private String passwordHash;

    @Getter(AccessLevel.PUBLIC)
    private String email;

    private static long currentId = 0;

    public User(String login, String passwordHash, String email) {
        this.id = currentId++;
        setEmail(email);
        setLogin(login);
        setPasswordHash(passwordHash);
    }

    public long getId() {
        return this.id;
    }


}
