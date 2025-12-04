package com.rahand.rip.government.infrastructure.api.dto;

import lombok.Data;

@Data
public class IdentityInquiryRequest {

    private String nationalId;
    private String birthDate;

    public String getNationalId() { return nationalId; }
    public String getBirthDate() { return birthDate; }
}
