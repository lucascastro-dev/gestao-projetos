package com.gestaoprojetos.srvgestaoprojetos.infra.exception;

import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends ApplicationException {
    public ObjectNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

    public static void isCondition(Boolean value, String errorMessage) {
        if (Boolean.TRUE.equals(value)) {
            throwException(errorMessage);
        }
    }

    private static void throwException(String errorMessage) {
        throw new ObjectNotFoundException(errorMessage);
    }
}
