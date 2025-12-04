package com.rahand.rip.government.domain.valueobject;

import com.rahand.rip.government.domain.exception.InvalidNationalIdException;

public record NationalId(String value) {

    public NationalId {
        if (value == null || !value.matches("\\d{10}")) {
            throw new InvalidNationalIdException("کد ملی باید ۱۰ رقمی باشد: " + value);
        }

        if (!isValid(value)) {
            throw new InvalidNationalIdException("کد ملی ساختاری نامعتبر دارد: " + value);
        }
    }

    private boolean isValid(String nationalId) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(nationalId.charAt(i)) * (10 - i);
        }
        int remainder = sum % 11;
        int check = Character.getNumericValue(nationalId.charAt(9));
        return (remainder < 2 && check == remainder) ||
                (remainder >= 2 && check == 11 - remainder);
    }
}
