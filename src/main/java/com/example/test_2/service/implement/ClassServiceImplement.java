package com.example.test_2.service.implement;

import com.example.test_2.entity.ClassEntity;
import com.example.test_2.entity.FamilyEntity;
import com.example.test_2.entity.StudentEntity;
import com.example.test_2.repository.ClassRepository;
import com.example.test_2.repository.StudentRepository;
import com.example.test_2.request.ClassRequest;
import com.example.test_2.response.ClassResponse;
import com.example.test_2.response.FamilyResponse;
import com.example.test_2.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassServiceImplement implements ClassService {
    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ClassEntity addClass(Long studentId, ClassEntity classEntity) {
        StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("student not found"));

        ClassEntity insertClass = new ClassEntity();
        insertClass.setClassId(classEntity.getClassId());
        insertClass.setClassName(classEntity.getClassName());
        insertClass.setGradeLevel(classEntity.getGradeLevel());
        //insertClass.setStudentEntities(studentEntity);

        ClassEntity addClass = classRepository.save(insertClass);
        return null;
    }

    @Override
    public ClassResponse updateClass(Long classId, ClassRequest classRequest) {
        ClassEntity upload = classRepository.findById(classId).orElseThrow(()->new RuntimeException("class not found"));
        upload.setClassName(classRequest.getClassName());
        upload.setGradeLevel(classRequest.getGradeLevel());

        ClassEntity classEntity = classRepository.save(upload);
        return mapToResponse(classEntity);
    }

    @Override
    public List<ClassResponse> fetchClassList() {
        List<ClassEntity> classEntities = classRepository.findAll();
        return classEntities.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public ClassResponse FindClassById(Long classId) {
        Optional<ClassEntity> optionalClass = classRepository.findById(classId);
        return optionalClass.map(this::mapToResponse).orElse(null);
    }

    @Override
    public void deleteClassById(Long classId) {
        classRepository.deleteById(classId);
    }

    private ClassResponse mapToResponse(ClassEntity classEntity){
        ClassResponse classResponse = new ClassResponse();
        classResponse.setClassId(classEntity.getClassId());
        classResponse.setClassName(classEntity.getClassName());
        classResponse.setGradeLevel(classEntity.getGradeLevel());

        return classResponse;
    }
}
