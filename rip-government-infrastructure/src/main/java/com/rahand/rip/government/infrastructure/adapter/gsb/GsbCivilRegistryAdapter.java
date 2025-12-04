package com.rahand.rip.government.infrastructure.adapter.gsb;

import com.rahand.rip.government.application.port.output.CivilRegistryProviderPort;
import com.rahand.rip.government.domain.entity.IdentityCheckResult;
import com.rahand.rip.government.domain.valueobject.BirthDate;
import com.rahand.rip.government.domain.valueobject.NationalId;
import com.rahand.rip.government.infrastructure.adapter.converter.CivilRegistryConverter;
import com.rahand.rip.government.infrastructure.dto.CivilRegistryResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("gsbProvider")
public class GsbCivilRegistryAdapter implements CivilRegistryProviderPort {

    private final RestTemplate rest = new RestTemplate();

    @Override
    public IdentityCheckResult fetchIdentity(NationalId nationalId, BirthDate birthDate) {

        String url = "https://api.gsb.ir/v1/civil/check";

        GsbRequest req = new GsbRequest(nationalId.value(), birthDate.value());

        CivilRegistryResponse resp = rest.postForObject(url, req, CivilRegistryResponse.class);

        return CivilRegistryConverter.toDomain(resp, nationalId);
    }

    record GsbRequest(String nid, String dob) {}
}
