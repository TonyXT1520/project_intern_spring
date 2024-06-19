package com.example.test_2.service;

import com.example.test_2.entity.ClassEntity;
import com.example.test_2.request.ClassRequest;
import com.example.test_2.response.ClassResponse;

import java.util.List;

public interface ClassService {
    ClassEntity addClass(Long studentId,ClassEntity classEntity);

    ClassResponse updateClass(Long classId,ClassRequest classRequest);

    List<ClassResponse> fetchClassList();

    ClassResponse FindClassById(Long classId);

    void deleteClassById(Long classId);
}
