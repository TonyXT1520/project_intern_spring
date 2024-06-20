package com.example.test_2.response;

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
}
