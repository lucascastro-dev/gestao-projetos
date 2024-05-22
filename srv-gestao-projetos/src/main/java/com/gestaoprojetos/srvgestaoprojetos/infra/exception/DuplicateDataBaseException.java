package com.gestaoprojetos.srvgestaoprojetos.infra.exception;

import org.springframework.http.HttpStatus;

public class DuplicateDataBaseException extends ApplicationException {
    public DuplicateDataBaseException(String message) {
        super(message, HttpStatus.CONFLICT);
    }

    public static void isCondition(boolean condition, String errorMessage) {
        if (Boolean.TRUE.equals(condition)) {
            throwException(errorMessage);
        }
    }

    private static void throwException(String errorMessage) {
        throw new DuplicateDataBaseException(errorMessage);
    }
}
