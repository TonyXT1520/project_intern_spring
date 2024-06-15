package com.example.test_2.service.implement;

import com.example.test_2.entity.AcademicResultEntity;
import com.example.test_2.entity.FamilyEntity;
import com.example.test_2.repository.AcademicResultRepository;
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

//    @Override
//    public AcademicResultResponse addAcademicResult(AcademicResultRequest academicResultRequest) {
//        AcademicResultEntity insertAcademicResult = new AcademicResultEntity();
//        insertAcademicResult.setSubject(academicResultRequest.getSubject());
//        insertAcademicResult.setScore(academicResultRequest.getScore());
//        insertAcademicResult.setSemester(academicResultRequest.getSemester());
//        insertAcademicResult.setAcademicYear(academicResultRequest.getAcademicResult());
//
//        AcademicResultEntity addResult = academicResultRepository.save(insertAcademicResult);
//        return mapToResponse(addResult);
//    }

    @Override
    public List<AcademicResultResponse> fetchAcademicResultList() {
        List<AcademicResultEntity> academicResultEntities = academicResultRepository.findAll();
        return academicResultEntities.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public AcademicResultResponse FindAcademicResultById(Integer resultId) {
        Optional<AcademicResultEntity> optionalAcademicResult = academicResultRepository.findById(resultId);
        return optionalAcademicResult.map(this::mapToResponse).orElse(null);
    }

    @Override
    public void deleteAcademicResultById(Integer resultId) {
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
