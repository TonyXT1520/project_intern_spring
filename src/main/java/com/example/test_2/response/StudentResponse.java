package com.example.test_2.response;

import com.example.test_2.entity.StudentEntity;
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

    public static StudentResponse mapToResponse(StudentEntity studentEntity){
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setStudentId(studentEntity.getStudentId());
        studentResponse.setFullName(studentEntity.getFullName());
        studentResponse.setDateOfBirth(studentEntity.getDayofBirth());
        studentResponse.setGender(studentEntity.getGender());
        studentResponse.setAddress(studentEntity.getAddress());
        studentResponse.setPhone(studentEntity.getPhone());
        studentResponse.setEmail(studentEntity.getEmail());

        return studentResponse;
    }
}
