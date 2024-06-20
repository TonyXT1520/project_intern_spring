package com.example.test_2.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentAddRequest {
    private Long studentId;
    private String fullName;
    private String dateOfBirth;
    private String gender;
    private String address;
    private String phone;
    private String email;

}
