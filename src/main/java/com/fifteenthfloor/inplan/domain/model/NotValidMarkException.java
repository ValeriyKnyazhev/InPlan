package com.fifteenthfloor.inplan.domain.model;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
public class NotValidMarkException extends RuntimeException {

    public NotValidMarkException(String message) {
        super(message);
    }

}
