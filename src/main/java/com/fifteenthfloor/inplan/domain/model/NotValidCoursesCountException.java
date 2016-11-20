package com.fifteenthfloor.inplan.domain.model;

/**
 * @author Valeriy Knyazhev valeriy.knyazhev@yandex.ru
 */
public class NotValidCoursesCountException extends RuntimeException {

    public NotValidCoursesCountException(String message) {
        super(message);
    }

}
