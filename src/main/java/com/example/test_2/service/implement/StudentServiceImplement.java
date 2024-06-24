package com.example.test_2.service.implement;

import com.example.test_2.config.Validate;
import com.example.test_2.entity.ClassEntity;
import com.example.test_2.entity.FamilyEntity;
import com.example.test_2.entity.StudentEntity;
import com.example.test_2.repository.ClassRepository;
import com.example.test_2.repository.FamilyRepository;
import com.example.test_2.repository.StudentRepository;
import com.example.test_2.request.StudentAddRequest;
import com.example.test_2.request.StudentRequest;
import com.example.test_2.response.StudentResponse;
import com.example.test_2.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplement implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private ClassRepository classRepository;

    @Override
    public StudentResponse addStudent(Long familyId, StudentAddRequest studentAddRequest) {
        FamilyEntity familyEntity = familyRepository.findById(familyId).orElseThrow(()->new RuntimeException("family not found"));

        Validate.studentValidateDetails(studentAddRequest.getPhone(), studentAddRequest.getEmail(), studentAddRequest.getGender());

        StudentEntity insertEntity = new StudentEntity();
        insertEntity.setStudentId(studentAddRequest.getStudentId());
        insertEntity.setFullName(studentAddRequest.getFullName());
        insertEntity.setDayOfBirth(studentAddRequest.getDateOfBirth());
        insertEntity.setGender(studentAddRequest.getGender());
        insertEntity.setAddress(studentAddRequest.getAddress());
        insertEntity.setPhone(studentAddRequest.getPhone());
        insertEntity.setEmail(studentAddRequest.getEmail());
        insertEntity.setFamilyEntity(familyEntity);

        StudentEntity studentEntity1 = studentRepository.save(insertEntity);

        return StudentResponse.mapToResponse(studentEntity1);
    }


    @Override
    public List<StudentEntity> getAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    public StudentResponse findStudentById(Long studentId) {
        Optional<StudentEntity> optionalStudent = studentRepository.findById(studentId);
        return optionalStudent.map(StudentResponse::mapToResponse).orElse(null);
    }

    @Override
    @Transactional
    public StudentResponse updateStudent(Long studentId, StudentRequest studentRequest) {
        StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("student not found"));

        Validate.studentValidateDetails(studentRequest.getAddress(), studentRequest.getEmail(), studentRequest.getPhone());

        if(studentRequest.getAddress()  != null) {
            studentEntity.setAddress(studentRequest.getAddress());
        }
        if(studentRequest.getPhone() != null) {
            studentEntity.setPhone(studentRequest.getPhone());
        }
        if ((studentRequest.getEmail()) != null) {
            studentEntity.setEmail(studentRequest.getEmail());
        }

        StudentEntity uploadStudent = studentRepository.save(studentEntity);
        return StudentResponse.mapToResponse(uploadStudent);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public StudentEntity addClassToStudent(Long studentId, Long classId) {
        StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("student not found"));
        ClassEntity classEntity = classRepository.findById(classId).orElseThrow(()->new RuntimeException("class not found"));

        studentEntity.getClassEntities().add(classEntity);
        classEntity.getStudentEntities().add(studentEntity);

        studentRepository.save(studentEntity);
        classRepository.save(classEntity);
        return studentEntity;
    }

}
