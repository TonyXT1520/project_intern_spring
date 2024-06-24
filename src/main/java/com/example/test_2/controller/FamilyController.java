package com.example.test_2.controller;

import com.example.test_2.entity.FamilyEntity;
import com.example.test_2.request.FamilyRequest;
import com.example.test_2.response.FamilyResponse;
import com.example.test_2.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/family")
public class FamilyController {
    @Autowired
    private FamilyService familyService;

    @GetMapping("/allFamily")
    public List<FamilyEntity> fetchFamilyList() {
        return familyService.fetchFamilyList();
    }

    @GetMapping("/{id}")
    public FamilyResponse finFamilyById(@PathVariable("id") Long familyId){
        return familyService.findFamilyById(familyId);
    }

    @PostMapping("/addFamily")
    public FamilyResponse addFamilyById(@RequestBody FamilyRequest familyRequest){
        return familyService.addFamily(familyRequest);
    }

    @PutMapping("/updateFamily/{id}")
    public FamilyResponse updateFamily(@PathVariable("id") Long familyId, @RequestBody FamilyRequest familyRequest){
        return familyService.updateFamily(familyId, familyRequest);
    }

    @DeleteMapping("/deleteTuition/{id}")
    public String deleteFamily(@PathVariable("id") Long familyId){
        familyService.deleteFamilyById(familyId);
        return "Deleted Successfully";
    }

}
