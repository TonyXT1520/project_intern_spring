package com.example.test_2.service.implement;

import com.example.test_2.entity.AcademicResultEntity;
import com.example.test_2.entity.FamilyEntity;
import com.example.test_2.entity.StudentEntity;
import com.example.test_2.repository.AcademicResultRepository;
import com.example.test_2.repository.StudentRepository;
import com.example.test_2.request.AcademicResultRequest;
import com.example.test_2.response.AcademicResultResponse;
import com.example.test_2.service.AcademicResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

        insertAcademicResult.setResultId(academicResultEntity.getResultId());
        insertAcademicResult.setSubject(academicResultEntity.getSubject());
        insertAcademicResult.setScore(academicResultEntity.getScore());
        insertAcademicResult.setSemester(academicResultEntity.getSemester());
        insertAcademicResult.setAcademicYear(academicResultEntity.getAcademicYear());
        insertAcademicResult.setStudentEntity(studentEntity);

        AcademicResultEntity addResult = academicResultRepository.save(insertAcademicResult);
        return null;
    }

    @Override
    public AcademicResultResponse updateAcademicResult(Long resultId, AcademicResultRequest academicResultRequest) {
        AcademicResultEntity academicResultEntity = academicResultRepository.findById(resultId).orElseThrow(()->new RuntimeException("result not found"));

        AcademicResultEntity upload = new AcademicResultEntity();
        upload.setSubject(academicResultRequest.getSubject());
        upload.setScore(academicResultRequest.getScore());
        upload.setSemester(academicResultRequest.getSemester());
        upload.setAcademicYear(academicResultRequest.getAcademicResult());

        AcademicResultEntity academicResult = academicResultRepository.save(upload);
        return mapToResponse(academicResultEntity);
    }

    @Override
    public List<AcademicResultResponse> fetchAcademicResultList() {
        List<AcademicResultEntity> academicResultEntities = academicResultRepository.findAll();
        return academicResultEntities.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public AcademicResultResponse FindAcademicResultById(Long resultId) {
        Optional<AcademicResultEntity> optionalAcademicResult = academicResultRepository.findById(resultId);
        return optionalAcademicResult.map(this::mapToResponse).orElse(null);
    }

    @Override
    public void deleteAcademicResultById(Long resultId) {
        academicResultRepository.deleteById(resultId);
    }

    private AcademicResultResponse mapToResponse(AcademicResultEntity academicResultEntity){
        AcademicResultResponse academicResultResponse = new AcademicResultResponse();
        academicResultResponse.setResultId(academicResultEntity.getResultId());
        academicResultResponse.setSubject(academicResultEntity.getSubject());
        academicResultResponse.setScore(academicResultEntity.getScore());
        academicResultResponse.setSemester(academicResultEntity.getSemester());
        academicResultResponse.setAcademicResul(academicResultEntity.getAcademicYear());

        return academicResultResponse;
    }
}
