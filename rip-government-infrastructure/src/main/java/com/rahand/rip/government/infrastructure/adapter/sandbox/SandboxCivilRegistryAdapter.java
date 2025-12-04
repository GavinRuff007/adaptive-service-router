package com.rahand.rip.government.infrastructure.adapter.sandbox;

import com.rahand.rip.government.application.port.output.CivilRegistryProviderPort;
import com.rahand.rip.government.domain.entity.Citizen;
import com.rahand.rip.government.domain.entity.IdentityCheckResult;
import com.rahand.rip.government.domain.valueobject.BirthDate;
import com.rahand.rip.government.domain.valueobject.NationalId;
import org.springframework.stereotype.Component;

@Component("sandboxProvider")
public class SandboxCivilRegistryAdapter implements CivilRegistryProviderPort {

    @Override
    public IdentityCheckResult fetchIdentity(NationalId nationalId, BirthDate birthDate) {

        Citizen citizen = new Citizen(
                "Test",
                "User",
                "TestFather",
                birthDate.value(),
                nationalId.value()
        );

        return new IdentityCheckResult(true, citizen);
    }
}
