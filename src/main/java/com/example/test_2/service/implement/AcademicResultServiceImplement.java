package com.example.test_2.service.implement;

import com.example.test_2.entity.AcademicResultEntity;

import com.example.test_2.entity.StudentEntity;
import com.example.test_2.repository.AcademicResultRepository;
import com.example.test_2.repository.StudentRepository;
import com.example.test_2.request.AcademicResultRequest;
import com.example.test_2.response.AcademicResultResponse;
import com.example.test_2.service.AcademicResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AcademicResultServiceImplement implements AcademicResultService {

    @Autowired
    private AcademicResultRepository academicResultRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public AcademicResultEntity addAcademicResult(Long studentId, AcademicResultEntity academicResultEntity) {
        StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("student not found"));
        AcademicResultEntity insertAcademicResult = new AcademicResultEntity();


        insertAcademicResult.setResultId(Objects.requireNonNull(academicResultEntity.getResultId()));
        insertAcademicResult.setSubject(Objects.requireNonNull(academicResultEntity.getSubject()));
        insertAcademicResult.setScore(Objects.requireNonNull(academicResultEntity.getScore()));
        insertAcademicResult.setSemester(Objects.requireNonNull(academicResultEntity.getSemester()));
        insertAcademicResult.setAcademicYear(Objects.requireNonNull(academicResultEntity.getAcademicYear()));
        insertAcademicResult.setStudentEntity(Objects.requireNonNull(studentEntity));

        return academicResultRepository.save(insertAcademicResult);
    }

    @Override
    public AcademicResultResponse updateAcademicResult(Long resultId, AcademicResultRequest academicResultRequest) {
        AcademicResultEntity academicResultEntity = academicResultRepository.findById(resultId).orElseThrow(()->new RuntimeException("result not found"));


        if(academicResultRequest.getSubject() != null) {
            academicResultEntity.setSubject(academicResultRequest.getSubject());
        }
        if(academicResultRequest.getScore() != null) {
            academicResultEntity.setScore(academicResultRequest.getScore());
        }
        if (academicResultRequest.getSemester() != null) {
            academicResultEntity.setSemester(academicResultRequest.getSemester());
        }
        if(academicResultRequest.getAcademicResult() != null) {
            academicResultEntity.setAcademicYear(academicResultRequest.getAcademicResult());
        }

        AcademicResultEntity academicResult = academicResultRepository.save(academicResultEntity);
        return AcademicResultResponse.mapToResponse(academicResult);
    }

    @Override
    public List<AcademicResultResponse> fetchAcademicResultList() {
        List<AcademicResultEntity> academicResultEntities = academicResultRepository.findAll();
        return academicResultEntities.stream().map(AcademicResultResponse::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public AcademicResultResponse FindAcademicResultById(Long resultId) {
        Optional<AcademicResultEntity> optionalAcademicResult = academicResultRepository.findById(resultId);
        return optionalAcademicResult.map(AcademicResultResponse::mapToResponse).orElse(null);
    }

    @Override
    public void deleteAcademicResultById(Long resultId) {
        academicResultRepository.deleteById(resultId);
    }


}
