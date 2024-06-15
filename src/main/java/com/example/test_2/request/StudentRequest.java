package com.example.test_2.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {
    private String fullName;
    private String dateOfBirth;
    private String gender;
    private String address;
    private String phone;
    private String email;
}
