package com.rahand.rip.government.application.port.input;

import com.rahand.rip.government.domain.entity.IdentityCheckResult;
import com.rahand.rip.government.domain.valueobject.BirthDate;
import com.rahand.rip.government.domain.valueobject.NationalId;

public interface IdentityInquiryUseCase {

    IdentityCheckResult inquire(NationalId nationalId, BirthDate birthDate);
}
