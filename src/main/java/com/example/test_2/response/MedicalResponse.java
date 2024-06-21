package com.example.test_2.response;

import com.example.test_2.entity.MedicalEntity;
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

    public static MedicalResponse mapToResponse(MedicalEntity medicalEntity){

        return new MedicalResponse(medicalEntity.getMedicalId(), medicalEntity.getHealthStatus(), medicalEntity.getVaccinationHistory());
    }
}
