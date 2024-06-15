package com.example.test_2.service.implement;

import com.example.test_2.entity.FamilyEntity;
import com.example.test_2.entity.StudentEntity;
import com.example.test_2.entity.TuitionEntity;
import com.example.test_2.repository.FamilyRepository;
import com.example.test_2.repository.StudentRepository;
import com.example.test_2.request.FamilyRequest;
import com.example.test_2.response.FamilyResponse;
import com.example.test_2.response.TuitionResponse;
import com.example.test_2.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FamilyServiceImplement implements FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

//    @Override
//    public FamilyResponse addFamily(FamilyRequest familyRequest) {
//        FamilyEntity insertFamily = new FamilyEntity();
//        insertFamily.setFatherName(familyRequest.getFatherName());
//        insertFamily.setMotherName(familyRequest.getMotherName());
//
//        FamilyEntity addFamily = familyRepository.save(insertFamily);
//        return mapToResponse(addFamily);
//    }

    @Override
    public List<FamilyResponse> fetchFamilyList() {
        List<FamilyEntity> familyEntities = familyRepository.findAll();
        return familyEntities.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public FamilyResponse findFamilyById(Integer famiyId) {
        Optional<FamilyEntity> optionalFamily = familyRepository.findById(famiyId);
        return optionalFamily.map(this::mapToResponse).orElse(null);
    }

    @Override
    public void deleteFamilyById(Integer familyId) {
        familyRepository.deleteById(familyId);
    }

    private FamilyResponse mapToResponse(FamilyEntity familyEntity){
        FamilyResponse familyResponse = new FamilyResponse();
        familyResponse.setFamilyId(familyEntity.getFamilyId());
        familyResponse.setFatherName(familyEntity.getFatherName());
        familyResponse.setMotherName(familyEntity.getMotherName());

        return familyResponse;
    }
}
