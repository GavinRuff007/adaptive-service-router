package com.rahand.rip.government.infrastructure.api.controller;

import com.rahand.rip.government.application.port.input.IdentityInquiryUseCase;
import com.rahand.rip.government.domain.entity.IdentityCheckResult;
import com.rahand.rip.government.domain.valueobject.BirthDate;
import com.rahand.rip.government.domain.valueobject.NationalId;
import com.rahand.rip.government.infrastructure.api.dto.IdentityInquiryRequest;
import com.rahand.rip.government.infrastructure.api.dto.IdentityInquiryResponse;
import com.rahand.rip.government.infrastructure.api.mapper.IdentityResponseMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/identity")
@Tag(name = "Identity Inquiry", description = "استعلام ثبت احوال")
public class IdentityInquiryController {

    private final IdentityInquiryUseCase useCase;

    public IdentityInquiryController(IdentityInquiryUseCase useCase) {
        this.useCase = useCase;
    }

    @Operation(
            summary = "استعلام تطابق کدملی",
            description = "استعلام ثبت احوال با ورودی کدملی و تاریخ تولد"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "موفق"),
            @ApiResponse(responseCode = "400", description = "ورودی نامعتبر"),
            @ApiResponse(responseCode = "500", description = "خطای سرویس دهنده")
    })
    @PostMapping("/check")
    public IdentityInquiryResponse check(@RequestBody IdentityInquiryRequest request) {

        IdentityCheckResult result = useCase.inquire(
                new NationalId(request.getNationalId()),
                new BirthDate(request.getBirthDate())
        );

        return IdentityResponseMapper.toApiResponse(result);
    }
}
