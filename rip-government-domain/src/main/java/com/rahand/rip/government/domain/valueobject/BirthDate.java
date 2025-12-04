package com.rahand.rip.government.domain.valueobject;

import com.rahand.rip.government.domain.exception.InvalidBirthDateException;

public record BirthDate(String value) {

    public BirthDate {
        if (value == null || !value.matches("\\d{8}")) {
            throw new InvalidBirthDateException("تاریخ تولد باید ۸ رقمی باشد: " + value);
        }
    }
}
