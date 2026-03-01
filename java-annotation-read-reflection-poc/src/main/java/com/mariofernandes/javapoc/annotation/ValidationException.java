package com.mariofernandes.javapoc.annotation;

import java.util.List;

public class ValidationException extends RuntimeException {
    private final List<String> violations;

    public ValidationException(List<String> violations) {
        super("Validation failed: " + violations);
        this.violations = violations;
    }

    public List<String> getViolations() {
        return this.violations;
    }
}
