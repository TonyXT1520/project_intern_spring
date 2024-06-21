package com.example.test_2.response;

import com.example.test_2.entity.ClassEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassResponse {
    private Long classId;
    private String className;
    private String gradeLevel;

    public static ClassResponse mapToResponse(ClassEntity classEntity){
        ClassResponse classResponse = new ClassResponse();
        classResponse.setClassId(classEntity.getClassId());
        classResponse.setClassName(classEntity.getClassName());
        classResponse.setGradeLevel(classEntity.getGradeLevel());

        return classResponse;
    }

}
