package com.example.test_2.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {
    private Integer studentId;
    private String fullName;
    private String dateOfBirth;
    private String gender;
    private String address;
    private String phone;
    private String email;
}
