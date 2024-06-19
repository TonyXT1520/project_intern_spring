package com.example.test_2.service;

import com.example.test_2.entity.MedicalEntity;
import com.example.test_2.request.MedicalRequest;
import com.example.test_2.response.MedicalResponse;

import java.util.List;

public interface MedicalService {
    MedicalEntity addMedical(Long studentId, MedicalEntity medicalEntity);

    List<MedicalResponse> fetchMedicalList();

    MedicalResponse FindMedicalById(Long medicalId);

    MedicalResponse updateMedical(Long medicalId, MedicalRequest medicalRequest);

    void deleteMedicalById(Long medicalId);
}
