package com.rahand.rip.government.infrastructure.api.dto;

public class IdentityInquiryResponse {

    private boolean match;
    private CitizenResponse citizen;

    public IdentityInquiryResponse(boolean match, CitizenResponse citizen) {
        this.match = match;
        this.citizen = citizen;
    }

    public boolean isMatch() { return match; }
    public CitizenResponse getCitizen() { return citizen; }
}
