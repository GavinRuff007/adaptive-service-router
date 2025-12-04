package com.rahand.rip.government.infrastructure.config;

import com.rahand.rip.government.application.port.input.IdentityInquiryUseCase;
import com.rahand.rip.government.application.port.output.CivilRegistryProviderPort;
import com.rahand.rip.government.application.service.IdentityInquiryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UseCaseConfig {

    @Bean
    public IdentityInquiryUseCase identityInquiryUseCase(CivilRegistryProviderPort routingProvider) {
        return new IdentityInquiryService(routingProvider);
    }
}
