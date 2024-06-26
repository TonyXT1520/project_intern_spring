package com.example.test_2.service.implement;

import com.example.test_2.config.Validate;
import com.example.test_2.entity.FamilyEntity;
import com.example.test_2.repository.FamilyRepository;
import com.example.test_2.request.FamilyRequest;
import com.example.test_2.response.FamilyResponse;
import com.example.test_2.service.FamilyService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FamilyServiceImplement implements FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    @Override
    @Transactional
    public FamilyResponse addFamily(FamilyRequest familyRequest) {
        Validate.familyValidateDetails(familyRequest.getFatherPhone(), familyRequest.getMotherPhone());

        FamilyEntity insertFamily = new FamilyEntity();
        insertFamily.setFamilyId(Objects.requireNonNull(familyRequest.getFamilyId()));
        insertFamily.setFatherName(Objects.requireNonNull(familyRequest.getFatherName()));
        insertFamily.setFatherPhone(Objects.requireNonNull(familyRequest.getFatherPhone()));
        insertFamily.setMotherName(Objects.requireNonNull(familyRequest.getMotherName()));
        insertFamily.setMotherPhone(Objects.requireNonNull(familyRequest.getMotherPhone()));

        FamilyEntity addFamily = familyRepository.save(insertFamily);
        return FamilyResponse.mapToResponse(addFamily);
    }

    @Override
    public FamilyResponse updateFamily(Long familyId, FamilyRequest familyRequest) {
        FamilyEntity upload = familyRepository.findById(familyId).orElseThrow(()->new RuntimeException("family not found"));

        if(familyRequest.getFatherPhone() != null) {
            upload.setFatherPhone(familyRequest.getFatherPhone());
        }if(familyRequest.getMotherPhone() != null) {
            upload.setMotherPhone(familyRequest.getMotherPhone());
        }

        FamilyEntity familyEntity = familyRepository.save(upload);
        return FamilyResponse.mapToResponse(familyEntity);
    }

    @Override
    public List<FamilyEntity> fetchFamilyList() {
        return familyRepository.findAll();
    }

    @Override
    public FamilyResponse findFamilyById(Long familyId) {
        Optional<FamilyEntity> optionalFamily = familyRepository.findById(familyId);
        return optionalFamily.map(FamilyResponse::mapToResponse).orElse(null);
    }

    @Override
    public void deleteFamilyById(Long familyId) {
        familyRepository.deleteById(familyId);
    }


}
