package com.rahand.rip.government.infrastructure.api.dto;


import java.time.LocalDateTime;

import static com.rahand.rip.government.infrastructure.api.common.CommandUtil.convertToPersianDate;

public record ApiResponse<T>(
        boolean success,
        T data,
        ApiError error,
        String jalaliDate,
        String isoDate
) {
    public static <T> ApiResponse<T> ok(T data) {
        LocalDateTime now = LocalDateTime.now();
        return new ApiResponse<>(
                true,
                data,
                null,
                convertToPersianDate(now),
                now.toString()
        );
    }

    public static <T> ApiResponse<T> fail(String code, String message) {
        LocalDateTime now = LocalDateTime.now();
        return new ApiResponse<>(
                false,
                null,
                new ApiError(code, message),
                convertToPersianDate(now),
                now.toString()
        );
    }

    public record ApiError(String code, String message) {}
}
