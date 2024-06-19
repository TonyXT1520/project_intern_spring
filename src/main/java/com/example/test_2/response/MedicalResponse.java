package com.example.test_2.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicalResponse {
    private Long medicalId;
    private String healthStatus;
    private String vaccinationHistory;

    public MedicalResponse(Long medicalId, String healthStatus, String vaccinationHistory) {
        this.medicalId = medicalId;
        this.healthStatus = healthStatus;
        this.vaccinationHistory = vaccinationHistory;
    }
}
