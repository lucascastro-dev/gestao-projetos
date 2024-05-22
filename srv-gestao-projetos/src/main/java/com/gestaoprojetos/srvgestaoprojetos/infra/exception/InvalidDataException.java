package com.gestaoprojetos.srvgestaoprojetos.infra.exception;

import com.gestaoprojetos.srvgestaoprojetos.domain.util.Util;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class InvalidDataException extends ApplicationException {

    public InvalidDataException(String errorMessage) {
        super(errorMessage, HttpStatus.BAD_REQUEST);
    }

    public static void isNullOrEmpty(String value, String errorMessage) {
        if (Util.isNullOrEmpty(value)) {
            throwException(errorMessage);
        }
    }

    public static void isNullOrEmpty(Integer value, String errorMessage) {
        if (Objects.isNull(value)) {
            throwException(errorMessage);
        }
    }

    public static void isNullOrEmpty(Double value, String errorMessage) {
        if (Util.isNullOrEmpty(value)) {
            throwException(errorMessage);
        }
    }

    public static void isNullOrEmpty(Long value, String errorMessage) {
        if (Util.isNullOrEmpty(value)) {
            throwException(errorMessage);
        }
    }

    public static void isNullOrEmpty(int value, String errorMessage) {
        if (value == 0) {
            throwException(errorMessage);
        }
    }

    public static void isNullOrEmpty(BigDecimal value, String errorMessage) {
        if (value.intValue() == 0) {
            throwException(errorMessage);
        }
    }

    public static void isNullOrEmpty(long value, String errorMessage) {
        if (value == 0) {
            throwException(errorMessage);
        }
    }

    public static void isNullOrEmpty(Object value, String errorMessage) {
        if (Objects.isNull(value)) {
            throwException(errorMessage);
        }
    }

    public static void isNullOrEmpty(List<?> value, String errorMessage) {
        if (Util.isNullOrEmpty(value)) {
            throwException(errorMessage);
        }
    }

    public static void isNullOrEmpty(Set<?> value, String errorMessage) {
        if (Util.isNullOrEmpty(value)) {
            throwException(errorMessage);
        }
    }

    public static void isNullOrEmpty(Map<?, ?> value, String errorMessage) {
        if (Objects.isNull(value)) {
            throwException(errorMessage);
        }
    }

    public static void isNullOrEmpty(LocalDate value, String errorMessage) {
        if (Objects.isNull(value)) {
            throwException(errorMessage);
        }
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