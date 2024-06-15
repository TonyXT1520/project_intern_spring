package com.example.test_2.service;

import com.example.test_2.entity.FamilyEntity;
import com.example.test_2.repository.FamilyRepository;
import com.example.test_2.request.FamilyRequest;
import com.example.test_2.response.FamilyResponse;

import java.util.List;

public interface FamilyService{
    //FamilyResponse addFamily(FamilyRequest familyRequest);

    List<FamilyResponse> fetchFamilyList();

    FamilyResponse findFamilyById(Integer famiyId);

    void deleteFamilyById(Integer familyId);
}
