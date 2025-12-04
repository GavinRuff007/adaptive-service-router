package com.rahand.rip.government.infrastructure.api.dto;

public class CitizenResponse {

    private String firstName;
    private String lastName;
    private String fatherName;
    private String nationalId;
    private String birthDate;

    public CitizenResponse(String firstName, String lastName, String fatherName, String nationalId, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.nationalId = nationalId;
        this.birthDate = birthDate;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getFatherName() { return fatherName; }
    public String getNationalId() { return nationalId; }
    public String getBirthDate() { return birthDate; }
}
