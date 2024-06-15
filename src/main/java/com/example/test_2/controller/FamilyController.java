package com.example.test_2.controller;

import com.example.test_2.entity.FamilyEntity;
import com.example.test_2.repository.FamilyRepository;
import com.example.test_2.request.FamilyRequest;
import com.example.test_2.request.TuitionRequest;
import com.example.test_2.response.FamilyResponse;
import com.example.test_2.response.TuitionResponse;
import com.example.test_2.service.FamilyService;
import com.example.test_2.service.StudentService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/family")
public class FamilyController {
    @Autowired
    private FamilyService familyService;

    @GetMapping("/allFamily")
    public List<FamilyResponse> fetchFamilyList() {
        return familyService.fetchFamilyList();
    }

    @GetMapping("/{id}")
    public FamilyResponse finFamilyById(@PathVariable("id") Integer familyId){
        return familyService.findFamilyById(familyId);
    }

//    @PostMapping("/addFamily")
//    public FamilyResponse addFamilyById(@RequestBody FamilyRequest familyRequest){
//        return familyService.addFamily(familyRequest);
//    }

    @DeleteMapping("/deleteTuition/{id}")
    public String deleteFamily(@PathVariable("id") Integer familyId){
        familyService.deleteFamilyById(familyId);
        return "Deleted Successfully";
    }

}
