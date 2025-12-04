package com.rahand.rip.government.infrastructure.adapter.converter;

import com.rahand.rip.government.domain.entity.Citizen;
import com.rahand.rip.government.domain.entity.IdentityCheckResult;
import com.rahand.rip.government.domain.valueobject.NationalId;
import com.rahand.rip.government.infrastructure.dto.CivilRegistryResponse;

public class CivilRegistryConverter {

    public static IdentityCheckResult toDomain(CivilRegistryResponse resp, NationalId nationalId) {

        Citizen citizen = new Citizen(
                resp.getFirstName(),
                resp.getLastName(),
                resp.getFatherName(),
                resp.getBirthDate(),
                nationalId.value()
        );

        return new IdentityCheckResult(resp.isMatch(), citizen);
    }
}
