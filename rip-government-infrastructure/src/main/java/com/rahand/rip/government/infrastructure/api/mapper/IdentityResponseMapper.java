package com.rahand.rip.government.infrastructure.api.mapper;

import com.rahand.rip.government.domain.entity.Citizen;
import com.rahand.rip.government.domain.entity.IdentityCheckResult;
import com.rahand.rip.government.infrastructure.api.dto.CitizenResponse;
import com.rahand.rip.government.infrastructure.api.dto.IdentityInquiryResponse;

public class IdentityResponseMapper {

    public static IdentityInquiryResponse toApiResponse(IdentityCheckResult result) {

        Citizen citizen = result.citizen();

        CitizenResponse citizenResponse = new CitizenResponse(
                citizen.firstName(),
                citizen.lastName(),
                citizen.fatherName(),
                citizen.nationalId(),
                citizen.birthDate()
        );

        return new IdentityInquiryResponse(result.match(), citizenResponse);
    }
}
