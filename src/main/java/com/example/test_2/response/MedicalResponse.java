package com.example.test_2.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicalResponse {
    private Integer medicalId;
    private String healthStatus;
    private String vaccinationHistory;
}
