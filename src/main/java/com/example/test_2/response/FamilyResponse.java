package com.example.test_2.response;

import com.example.test_2.entity.FamilyEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamilyResponse {
    private Long familyId;
    private String fatherName;
    private String fatherPhone;
    private String motherName;
    private String motherPhone;

    public static FamilyResponse mapToResponse(FamilyEntity familyEntity){
        FamilyResponse familyResponse = new FamilyResponse();
        familyResponse.setFamilyId(familyEntity.getFamilyId());
        familyResponse.setFatherName(familyEntity.getFatherName());
        familyResponse.setFatherPhone(familyResponse.getFatherPhone());
        familyResponse.setMotherName(familyEntity.getMotherName());
        familyResponse.setMotherPhone(familyEntity.getMotherPhone());

        return familyResponse;
    }
}


