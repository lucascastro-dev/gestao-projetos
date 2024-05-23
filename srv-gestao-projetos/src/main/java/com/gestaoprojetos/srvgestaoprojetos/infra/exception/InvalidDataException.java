package com.gestaoprojetos.srvgestaoprojetos.infra.exception;

import org.springframework.http.HttpStatus;

public class InvalidDataException extends ApplicationException {

    public InvalidDataException(String errorMessage) {
        super(errorMessage, HttpStatus.BAD_REQUEST);
    }

    public static void isCondition(boolean condition, String errorMessage) {
        if (Boolean.TRUE.equals(condition)) {
            throwException(errorMessage);
        }
    }

    private static void throwException(String errorMessage) {
        throw new InvalidDataException(errorMessage);
    }


}