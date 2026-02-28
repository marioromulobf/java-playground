package com.mariofernandes.javapoc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // available at runtime
@Target(ElementType.FIELD) // only on field
public @interface NotBlank {
    String message() default "%s must not be blank"; // string formatting
}
