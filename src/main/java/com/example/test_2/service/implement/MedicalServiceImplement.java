package com.example.test_2.service.implement;

import com.example.test_2.entity.FamilyEntity;
import com.example.test_2.entity.MedicalEntity;
import com.example.test_2.entity.StudentEntity;
import com.example.test_2.repository.MedicalRepository;
import com.example.test_2.request.MedicalRequest;
import com.example.test_2.response.FamilyResponse;
import com.example.test_2.response.MedicalResponse;
import com.example.test_2.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicalServiceImplement implements MedicalService {
    @Autowired
    private MedicalRepository medicalRepository;

//    @Override
//    public MedicalResponse addMedical(MedicalRequest medicalRequest) {
//        MedicalEntity insertMedical = new MedicalEntity();
//        insertMedical.setHealthStatus(medicalRequest.getHealthStatus());
//        insertMedical.setVaccinationHistory(medicalRequest.getVaccinationHistory());
//
//        MedicalEntity addMedical = medicalRepository.save(insertMedical);
//        return mapToResponse(addMedical);
//    }

    @Override
    public List<MedicalResponse> fetchMedicalList() {
        List<MedicalEntity> medicalEntities = medicalRepository.findAll();
        return medicalEntities.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public MedicalResponse FindMedicalById(Integer medicalId) {
        Optional<MedicalEntity> optionalMedical = medicalRepository.findById(medicalId);
        return optionalMedical.map(this::mapToResponse).orElse(null);
    }

    @Override
    public void deleteMedicalById(Integer medicalId) {
        medicalRepository.deleteById(medicalId);
    }

    private MedicalResponse mapToResponse(MedicalEntity medicalEntity){
        MedicalResponse medicalResponse = new MedicalResponse();
        medicalResponse.setMedicalId(medicalEntity.getMedicalId());
        medicalResponse.setHealthStatus(medicalEntity.getHealthStatus());
        medicalResponse.setVaccinationHistory(medicalEntity.getVaccinationHistory());

        return medicalResponse;
    }
}
