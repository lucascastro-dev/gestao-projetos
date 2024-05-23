package com.gestaoprojetos.srvgestaoprojetos.domain.util;

import com.gestaoprojetos.srvgestaoprojetos.infra.exception.InvalidDataException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class Util {
    Util() {
        throw new IllegalStateException("Static class");
    }

    public static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public static boolean isNullOrEmpty(Integer value) {
        return value == null;
    }

    public static boolean isNullOrEmpty(Double value) {
        return value == null;
    }

    public static boolean isNullOrEmpty(Long value) {
        return value == null;
    }

    public static boolean isNullOrEmpty(Object object) {
        return Objects.isNull(object);
    }

    public static boolean isNullOrEmpty(List<?> list) {
        return Objects.isNull(list) || list.isEmpty();
    }

    public static boolean isNullOrEmpty(Set<?> list) {
        return Objects.isNull(list) || list.isEmpty();
    }

    public static boolean isNullOrEmpty(Map<?, ?> map) {
        return Objects.isNull(map) || map.isEmpty();
    }

    public static boolean isNullOrEmpty(LocalDate date) {
        return Objects.isNull(date);
    }

    public static void validateFromStartValidityDate(LocalDate startValidate) {
        InvalidDataException.isCondition(startValidate.isBefore(LocalDate.now()),
                "Data informada não pode ser anterior a data atual");
    }

    public static void validateFromEndValidityDate(LocalDate startValidate, LocalDate endValidate) {
        InvalidDataException.isCondition(endValidate.isBefore(LocalDate.now()),
                "Data fim informada não pode ser anterior a data atual");
        InvalidDataException.isCondition(endValidate.isBefore(startValidate),
                "Data fim não pode ser anterior a data início");
    }

}
