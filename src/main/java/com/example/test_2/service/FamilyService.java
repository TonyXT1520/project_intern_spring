package com.example.test_2.service;

import com.example.test_2.entity.FamilyEntity;
import com.example.test_2.request.FamilyRequest;
import com.example.test_2.response.FamilyResponse;

import java.util.List;

public interface FamilyService{
    FamilyResponse addFamily(FamilyRequest familyRequest);

    FamilyResponse updateFamily(Long familyId, FamilyRequest familyRequest);

    List<FamilyEntity> fetchFamilyList();

    FamilyResponse findFamilyById(Long familyId);

    void deleteFamilyById(Long familyId);
}
