package com.example.test_2.service.implement;

import com.example.test_2.entity.StudentEntity;
import com.example.test_2.entity.TuitionEntity;
import com.example.test_2.repository.StudentRepository;
import com.example.test_2.request.StudentRequest;
import com.example.test_2.response.StudentResponse;
import com.example.test_2.response.TuitionResponse;
import com.example.test_2.service.StudentService;
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

    @Override
    public StudentResponse addStudent(StudentRequest studentRequest) {
        StudentEntity insertEntity = new StudentEntity();
        insertEntity.setFullName(studentRequest.getFullName());
        insertEntity.setDayofBirth(studentRequest.getDateOfBirth());
        insertEntity.setGender(studentRequest.getGender());
        insertEntity.setAddress(studentRequest.getAddress());
        insertEntity.setPhone(studentRequest.getPhone());
        insertEntity.setEmail(studentRequest.getEmail());

        StudentEntity addStudentById = studentRepository.save(insertEntity);
        return mapToResponse(addStudentById);
    }


    @Override
    public List<StudentResponse> fetchStudentList() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        return studentEntities.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public StudentResponse findStudentById(Integer studentId) {
        Optional<StudentEntity> optionalStudent = studentRepository.findById(studentId);
        return optionalStudent.map(this::mapToResponse).orElse(null);
    }

    @Override
    public StudentResponse updateStudent(StudentRequest studentRequest, Integer studentId) {
        Optional<StudentEntity> optionalStudent = studentRepository.findById(studentId);
        if(optionalStudent.isPresent()){
            StudentEntity studentEntity = optionalStudent.get();
            studentEntity.setFullName(studentRequest.getFullName());
            studentEntity.setDayofBirth(studentRequest.getDateOfBirth());
            studentEntity.setGender(studentRequest.getGender());

            StudentEntity updateStudent = studentRepository.save(studentEntity);
            return mapToResponse(updateStudent);
        }else {
            return null;
        }

    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    private StudentResponse mapToResponse(StudentEntity studentEntity){
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setStudentId(studentEntity.getStudentId());
        studentResponse.setFullName(studentEntity.getFullName());
        studentResponse.setDateOfBirth(studentEntity.getDayofBirth());
        studentResponse.setGender(studentEntity.getGender());

        return studentResponse;
    }
}
