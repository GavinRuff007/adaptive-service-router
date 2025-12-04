package com.rahand.rip.government.infrastructure.dto;

public class CivilRegistryResponse {

    private boolean match;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String birthDate;

    public boolean isMatch() { return match; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getFatherName() { return fatherName; }
    public String getBirthDate() { return birthDate; }
}
