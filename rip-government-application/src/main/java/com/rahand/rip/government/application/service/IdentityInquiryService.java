package com.rahand.rip.government.application.service;

import com.rahand.rip.government.application.port.input.IdentityInquiryUseCase;
import com.rahand.rip.government.application.port.output.CivilRegistryProviderPort;
import com.rahand.rip.government.domain.entity.IdentityCheckResult;
import com.rahand.rip.government.domain.valueobject.BirthDate;
import com.rahand.rip.government.domain.valueobject.NationalId;

public class IdentityInquiryService implements IdentityInquiryUseCase {

    private final CivilRegistryProviderPort provider;

    public IdentityInquiryService(CivilRegistryProviderPort provider) {
        this.provider = provider;
    }

    @Override
    public IdentityCheckResult inquire(NationalId nationalId, BirthDate birthDate) {
        return provider.fetchIdentity(nationalId, birthDate);
    }
}
