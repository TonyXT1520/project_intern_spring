package com.example.test_2.service.implement;

import com.example.test_2.entity.ClassEntity;
import com.example.test_2.entity.FamilyEntity;
import com.example.test_2.entity.StudentEntity;
import com.example.test_2.repository.ClassRepository;
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

//    @Override
//    public ClassResponse addClass(ClassRequest classRequest) {
//        ClassEntity insertClass = new ClassEntity();
//        insertClass.setClassName(classRequest.getClassName());
//        insertClass.setGradeLevel(classRequest.getGradeLevel());
//
//        ClassEntity addClass = classRepository.save(insertClass);
//        return mapToResponse(addClass);
//    }

    @Override
    public List<ClassResponse> fetchClassList() {
        List<ClassEntity> classEntities = classRepository.findAll();
        return classEntities.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public ClassResponse FindClassById(Integer classId) {
        Optional<ClassEntity> optionalClass = classRepository.findById(classId);
        return optionalClass.map(this::mapToResponse).orElse(null);
    }

    @Override
    public void deleteClassById(Integer classId) {
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
