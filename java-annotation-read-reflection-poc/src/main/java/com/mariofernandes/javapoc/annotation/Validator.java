package com.mariofernandes.javapoc.annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static void validate(Object obj) throws IllegalAccessException {
        List<String> violations = new ArrayList<>();

        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            Object value = field.get(obj);

            if (field.isAnnotationPresent(NotBlank.class)) {
                NotBlank annotation = field.getAnnotation(NotBlank.class);

                if (value == null || value.toString().isBlank()) {
                    violations.add(String.format(annotation.message(), field.getName()));
                }
            }

            if (field.isAnnotationPresent(Range.class)) {
                Range annotation = field.getAnnotation(Range.class);

                if (value instanceof Number number) {
                    int intValue = number.intValue();
                    if (intValue < annotation.min() || intValue > annotation.max()) {
                        violations.add(String.format(annotation.message(), field.getName())
                                .concat(" (expected: " + annotation.min() + ".." + annotation.max())
                                .concat(", got: " + intValue + ")")
                        );
                    }
                }
            }
        }

        if (!violations.isEmpty()) {
            throw new ValidationException(violations);
        }
    }
}
