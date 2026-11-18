package com.example.demo.core.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CharTypesValidator implements ConstraintValidator<CharTypes, String> {
    private int min;

    @Override
    public void initialize(CharTypes annotation) {
        this.min = annotation.min();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        int types = 0;
        if (value.chars().anyMatch(c -> c >= 'a' && c <= 'z'))
            types++;
        if (value.chars().anyMatch(c -> c >= 'A' && c <= 'Z'))
            types++;
        if (value.chars().anyMatch(c -> c >= '0' && c <= '9'))
            types++;
        return types >= min;
    }
}
