package com.example.test_2.service;

import com.example.test_2.entity.TuitionEntity;
import com.example.test_2.request.TuitionRequest;
import com.example.test_2.response.TuitionResponse;

import java.util.List;

public interface TuitionService {
    TuitionEntity addTuition(Long studentId, TuitionEntity tuitionEntity);

    List<TuitionResponse> getAllTuition();

    TuitionResponse FindTuitionById(Long tuitionId);

    TuitionResponse updateTuition(TuitionRequest tuitionRequest, Long tuitionId);

    void deleteTuitionById(Long tuitionId);
}
