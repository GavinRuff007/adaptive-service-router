package com.rahand.rip.government.application.port.output;

import com.rahand.rip.government.domain.entity.IdentityCheckResult;
import com.rahand.rip.government.domain.valueobject.BirthDate;
import com.rahand.rip.government.domain.valueobject.NationalId;

public interface CivilRegistryProviderPort {

    IdentityCheckResult fetchIdentity(NationalId nationalId, BirthDate birthDate);
}
