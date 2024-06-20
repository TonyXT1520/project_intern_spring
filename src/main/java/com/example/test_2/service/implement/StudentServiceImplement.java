package com.example.test_2.service.implement;

import com.example.test_2.entity.FamilyEntity;
import com.example.test_2.entity.StudentEntity;
import com.example.test_2.entity.TuitionEntity;
import com.example.test_2.repository.FamilyRepository;
import com.example.test_2.repository.StudentRepository;
import com.example.test_2.request.StudentAddRequest;
import com.example.test_2.request.StudentRequest;
import com.example.test_2.response.StudentResponse;
import com.example.test_2.response.TuitionResponse;
import com.example.test_2.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplement implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FamilyRepository familyRepository;

    @Override
    public StudentResponse addStudent(Long familyId, StudentAddRequest studentAddRequest) {
        FamilyEntity familyEntity = familyRepository.findById(familyId).orElseThrow(()->new RuntimeException("family not found"));

        StudentEntity insertEntity = new StudentEntity();
        insertEntity.setStudentId(studentAddRequest.getStudentId());
        insertEntity.setFullName(studentAddRequest.getFullName());
        insertEntity.setDayofBirth(studentAddRequest.getDateOfBirth());
        insertEntity.setGender(studentAddRequest.getGender());
        insertEntity.setAddress(studentAddRequest.getAddress());
        insertEntity.setPhone(studentAddRequest.getPhone());
        insertEntity.setEmail(studentAddRequest.getEmail());
        insertEntity.setFamilyEntity(familyEntity);

        StudentEntity studentEntity1 = studentRepository.save(insertEntity);

        return mapToResponse(studentEntity1);
    }


    @Override
    public List<StudentEntity> getAllStudents() {
        //List<StudentEntity> studentEntities = studentRepository.findAll();
        //studentEntities.stream().map(this::mapToResponse).collect(Collectors.toList())
        return (List<StudentEntity>) studentRepository.findAll();
    }

    @Override
    public StudentResponse findStudentById(Long studentId) {
        Optional<StudentEntity> optionalStudent = studentRepository.findById(studentId);
        return optionalStudent.map(this::mapToResponse).orElse(null);
    }

    @Override
    @Transactional
    public StudentResponse updateStudent(Long studentId, StudentRequest studentRequest) {
        StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("student not found"));

        studentEntity.setAddress(studentRequest.getAddress());
        studentEntity.setPhone(studentRequest.getPhone());
        studentEntity.setEmail(studentRequest.getEmail());

        StudentEntity uploadstudent = studentRepository.save(studentEntity);
        return mapToResponse(uploadstudent);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    private StudentResponse mapToResponse(StudentEntity studentEntity){
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setStudentId(studentEntity.getStudentId());
        studentResponse.setFullName(studentEntity.getFullName());
        studentResponse.setDateOfBirth(studentResponse.getDateOfBirth());
        studentResponse.setGender(studentResponse.getGender());
        studentResponse.setAddress(studentEntity.getAddress());
        studentResponse.setPhone(studentEntity.getPhone());
        studentResponse.setEmail(studentEntity.getEmail());

        return studentResponse;
    }
}
