package com.rahand.rip.government.infrastructure.adapter.astan;

import com.rahand.rip.government.application.port.output.CivilRegistryProviderPort;
import com.rahand.rip.government.domain.entity.IdentityCheckResult;
import com.rahand.rip.government.domain.valueobject.BirthDate;
import com.rahand.rip.government.domain.valueobject.NationalId;
import com.rahand.rip.government.infrastructure.adapter.converter.CivilRegistryConverter;
import com.rahand.rip.government.infrastructure.dto.CivilRegistryResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("astanProvider")
public class AstanCivilRegistryAdapter implements CivilRegistryProviderPort {

    private final RestTemplate rest = new RestTemplate();

    @Override
    public IdentityCheckResult fetchIdentity(NationalId nationalId, BirthDate birthDate) {

        String url = "https://api.astan.ir/civil/check";

        AstanRequest req = new AstanRequest(nationalId.value(), birthDate.value());

        CivilRegistryResponse response = rest.postForObject(url, req, CivilRegistryResponse.class);

        return CivilRegistryConverter.toDomain(response, nationalId);
    }

    record AstanRequest(String nationalId, String birthDate) {}
}
