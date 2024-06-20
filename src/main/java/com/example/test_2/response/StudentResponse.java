package com.example.test_2.response;

import com.example.test_2.entity.TuitionEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private Long studentId;
    private String fullName;
    private String dateOfBirth;
    private String gender;
    private String address;
    private String phone;
    private String email;


    //private List<TuitionEntity> tuitionEntities;
}
