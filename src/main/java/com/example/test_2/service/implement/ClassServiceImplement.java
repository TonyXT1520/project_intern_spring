package com.example.test_2.service.implement;

import com.example.test_2.entity.ClassEntity;
import com.example.test_2.entity.StudentEntity;
import com.example.test_2.repository.ClassRepository;
import com.example.test_2.repository.StudentRepository;
import com.example.test_2.request.ClassRequest;
import com.example.test_2.response.ClassResponse;
import com.example.test_2.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
        insertClass.setClassId(Objects.requireNonNull(classEntity.getClassId()));
        insertClass.setClassName(Objects.requireNonNull(classEntity.getClassName()));
        insertClass.setGradeLevel(Objects.requireNonNull(classEntity.getGradeLevel()));
        insertClass.setStudentEntities(Objects.requireNonNull(List.of(studentEntity)));

        return classRepository.save(insertClass);
    }

    @Override
    public ClassResponse updateClass(Long classId, ClassRequest classRequest) {
        ClassEntity upload = classRepository.findById(classId).orElseThrow(()->new RuntimeException("class not found"));

        if(classRequest.getClassName() != null) {
            upload.setClassName(classRequest.getClassName());
        }
        if (classRequest.getGradeLevel() != null) {
            upload.setGradeLevel(classRequest.getGradeLevel());
        }
        ClassEntity classEntity = classRepository.save(upload);
        return ClassResponse.mapToResponse(classEntity);
    }

    @Override
    public List<ClassResponse> fetchClassList() {
        List<ClassEntity> classEntities = classRepository.findAll();
        return classEntities.stream().map(ClassResponse::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public ClassResponse FindClassById(Long classId) {
        Optional<ClassEntity> optionalClass = classRepository.findById(classId);
        return optionalClass.map(ClassResponse::mapToResponse).orElse(null);
    }

    @Override
    public void deleteClassById(Long classId) {
        classRepository.deleteById(classId);
    }


}
