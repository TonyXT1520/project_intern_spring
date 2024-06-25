package com.example.test_2.controller;

import com.example.test_2.entity.MedicalEntity;
import com.example.test_2.request.MedicalRequest;
import com.example.test_2.response.MedicalResponse;
import com.example.test_2.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicals")
public class MedicalController {
    @Autowired
    private MedicalService medicalService;

    @GetMapping
    public List<MedicalResponse> fetchMedicalList() {
        return medicalService.fetchMedicalList();
    }

    @GetMapping("/{id}")
    public MedicalResponse findMedicalById(@PathVariable("id") Long medicalId){
        return medicalService.FindMedicalById(medicalId);
    }

    @PostMapping("/{id}")
    public MedicalEntity addMedical(@PathVariable("id") Long studentId,@RequestBody MedicalEntity medicalEntity){
        return medicalService.addMedical(studentId, medicalEntity);
    }

    @PutMapping("/{id}")
    public MedicalResponse updateMedical(@PathVariable("id") Long medicalId,@RequestBody MedicalRequest medicalRequest){
        return medicalService.updateMedical(medicalId, medicalRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteMedical(@PathVariable("id") Long medicalId){
        medicalService.deleteMedicalById(medicalId);
        return "Deleted Successfully";
    }
}
