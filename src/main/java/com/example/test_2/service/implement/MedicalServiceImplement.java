package com.example.test_2.service.implement;

import com.example.test_2.entity.MedicalEntity;
import com.example.test_2.entity.StudentEntity;
import com.example.test_2.repository.MedicalRepository;
import com.example.test_2.repository.StudentRepository;
import com.example.test_2.request.MedicalRequest;
import com.example.test_2.response.MedicalResponse;
import com.example.test_2.service.MedicalService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicalServiceImplement implements MedicalService {
    @Autowired
    private MedicalRepository medicalRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional
    public MedicalEntity addMedical(Long studentId, MedicalEntity medicalEntity) {
        StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("student not found"));

        MedicalEntity insertMedical = new MedicalEntity();
        insertMedical.setMedicalId(Objects.requireNonNull(medicalEntity.getMedicalId()));
        insertMedical.setHealthStatus(Objects.requireNonNull(medicalEntity.getHealthStatus()));
        insertMedical.setVaccinationHistory(Objects.requireNonNull(medicalEntity.getVaccinationHistory()));
        insertMedical.setStudentEntity(Objects.requireNonNull(studentEntity));

        return medicalRepository.save(insertMedical);
    }
    @Override
    @Transactional
    public MedicalResponse updateMedical(Long medicalId, MedicalRequest medicalRequest){
        MedicalEntity upload = medicalRepository.findById(medicalId).orElseThrow(()->new RuntimeException("medical not found"));

        if(medicalRequest.getHealthStatus() != null) {
            upload.setHealthStatus(medicalRequest.getHealthStatus());
        }
        if(medicalRequest.getVaccinationHistory() != null) {
            upload.setVaccinationHistory(medicalRequest.getVaccinationHistory());
        }

        MedicalEntity medicalEntity = medicalRepository.save(upload);
        return MedicalResponse.mapToResponse(medicalEntity);
    }

    @Override
    public List<MedicalResponse> fetchMedicalList() {
        List<MedicalEntity> medicalEntities = medicalRepository.findAll();
        return medicalEntities.stream().map(MedicalResponse::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public MedicalResponse FindMedicalById(Long medicalId) {
        Optional<MedicalEntity> optionalMedical = medicalRepository.findById(medicalId);
        return optionalMedical.map(MedicalResponse::mapToResponse).orElse(null);
    }

    @Override
    public void deleteMedicalById(Long medicalId) {
        medicalRepository.deleteById(medicalId);
    }




}
