package com.example.test_2.service;

import com.example.test_2.entity.AcademicResultEntity;
import com.example.test_2.entity.ClassEntity;
import com.example.test_2.request.AcademicResultRequest;
import com.example.test_2.response.AcademicResultResponse;

import java.util.List;

public interface AcademicResultService {
    //AcademicResultResponse addAcademicResult(AcademicResultRequest academicResultRequest);

    List<AcademicResultResponse> fetchAcademicResultList();

    AcademicResultResponse FindAcademicResultById(Integer resultId);

    void deleteAcademicResultById(Integer resultId);
}
