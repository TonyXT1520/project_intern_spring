package com.example.test_2.service;

import com.example.test_2.entity.TuitionEntity;
import com.example.test_2.request.TuitionRequest;
import com.example.test_2.response.TuitionResponse;

import java.util.List;

public interface TuitionService {
    //TuitionEntity addTuition(TuitionEntity tuitionEntity);

    List<TuitionResponse> fetchTuitionList();

    TuitionResponse FindTuitionById(Integer tuitionId);

    void deleteTuitionById(Integer tuitionId);
}
