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
import jakarta.transaction.Transactional;
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

    @Override
    @Transactional
    public FamilyEntity addFamily(FamilyEntity familyEntity) {
        FamilyEntity insertFamily = new FamilyEntity();
        insertFamily.setFatherName(familyEntity.getFatherName());
        insertFamily.setMotherName(familyEntity.getMotherName());

        FamilyEntity addFamily = familyRepository.save(insertFamily);
        return null;
    }

    @Override
    public FamilyResponse updateFamily(Long familyId, FamilyRequest familyRequest) {
        FamilyEntity upload = familyRepository.findById(familyId).orElseThrow(()->new RuntimeException("family not found"));
        upload.setFatherPhone(familyRequest.getFatherPhone());
        upload.setMotherPhone(familyRequest.getMotherPhone());

        FamilyEntity familyEntity = familyRepository.save(upload);
        return mapToResponse(familyEntity);
    }

    @Override
    public List<FamilyEntity> fetchFamilyList() {
        //List<FamilyEntity> familyEntities = familyRepository.findAll();
        //familyEntities.stream().map(this::mapToResponse).collect(Collectors.toList());
        return familyRepository.findAll();
    }

    @Override
    public FamilyResponse findFamilyById(Long famiyId) {
        Optional<FamilyEntity> optionalFamily = familyRepository.findById(famiyId);
        return optionalFamily.map(this::mapToResponse).orElse(null);
    }

    @Override
    public void deleteFamilyById(Long familyId) {
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
