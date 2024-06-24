package com.example.test_2.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FamilyRequest {
    private Long familyId;
    private String fatherName;
    private String fatherPhone;
    private String motherName;
    private String motherPhone;
}
