package com.rahand.rip.government.infrastructure.config;

import com.rahand.rip.government.application.port.output.CivilRegistryProviderPort;
import com.rahand.rip.government.infrastructure.adapter.astan.AstanCivilRegistryAdapter;
import com.rahand.rip.government.infrastructure.adapter.gsb.GsbCivilRegistryAdapter;
import com.rahand.rip.government.infrastructure.adapter.sandbox.SandboxCivilRegistryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ProviderConfig {

    @Bean
    public CivilRegistryProviderPort routingProvider(
            AstanCivilRegistryAdapter astan,
            GsbCivilRegistryAdapter gsb,
            SandboxCivilRegistryAdapter sandbox
    ) {
        return new RoutingCivilRegistryProvider(
                Map.of(
                        "astan", astan,
                        "gsb", gsb,
                        "sandbox", sandbox
                )
        );
    }
}
