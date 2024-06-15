package com.example.test_2.service;

import com.example.test_2.entity.MedicalEntity;
import com.example.test_2.request.MedicalRequest;
import com.example.test_2.response.MedicalResponse;

import java.util.List;

public interface MedicalService {
    //MedicalResponse addMedical(MedicalRequest medicalRequest);

    List<MedicalResponse> fetchMedicalList();

    MedicalResponse FindMedicalById(Integer medicalId);

    void deleteMedicalById(Integer medicalId);
}
