package com.example.test_2.response;

import com.example.test_2.entity.AcademicResultEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcademicResultResponse {
    private Long resultId;
    private String subject;
    private String score;
    private String semester;
    private String academicResul;

    public static AcademicResultResponse mapToResponse(AcademicResultEntity academicResultEntity){
        AcademicResultResponse academicResultResponse = new AcademicResultResponse();
        academicResultResponse.setResultId(academicResultEntity.getResultId());
        academicResultResponse.setSubject(academicResultEntity.getSubject());
        academicResultResponse.setScore(academicResultEntity.getScore());
        academicResultResponse.setSemester(academicResultEntity.getSemester());
        academicResultResponse.setAcademicResul(academicResultEntity.getAcademicYear());

        return academicResultResponse;
    }
}
