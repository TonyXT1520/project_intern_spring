package com.example.test_2.service;

import com.example.test_2.entity.AcademicResultEntity;
import com.example.test_2.request.AcademicResultRequest;
import com.example.test_2.response.AcademicResultResponse;

import java.util.List;

public interface AcademicResultService {
    AcademicResultEntity addAcademicResult(Long studentId,AcademicResultEntity academicResultEntity);

    AcademicResultResponse updateAcademicResult(Long resultId, AcademicResultRequest academicResultRequest);

    List<AcademicResultResponse> fetchAcademicResultList();

    AcademicResultResponse FindAcademicResultById(Long resultId);

    void deleteAcademicResultById(Long resultId);
}
