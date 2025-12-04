package com.rahand.rip.government.infrastructure.config;

import com.rahand.rip.government.application.port.output.CivilRegistryProviderPort;
import com.rahand.rip.government.domain.entity.IdentityCheckResult;
import com.rahand.rip.government.domain.valueobject.BirthDate;
import com.rahand.rip.government.domain.valueobject.NationalId;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

public class RoutingCivilRegistryProvider implements CivilRegistryProviderPort {

    private final Map<String, CivilRegistryProviderPort> providers;

    @Value("${provider.active:sandbox}")
    private String activeProvider;

    public RoutingCivilRegistryProvider(Map<String, CivilRegistryProviderPort> providers) {
        this.providers = providers;
    }

    @Override
    public IdentityCheckResult fetchIdentity(NationalId nationalId, BirthDate birthDate) {
        CivilRegistryProviderPort selected = providers.get(activeProvider);
        if (selected == null) {
            throw new IllegalArgumentException("No provider found for key: " + activeProvider);
        }
        return selected.fetchIdentity(nationalId, birthDate);
    }
}
