package com.example.test_2.service.implement;

import com.example.test_2.entity.ClassEntity;
import com.example.test_2.entity.StudentEntity;
import com.example.test_2.entity.TuitionEntity;
import com.example.test_2.repository.StudentRepository;
import com.example.test_2.repository.TuitionRepository;
import com.example.test_2.request.TuitionRequest;
import com.example.test_2.response.TuitionResponse;
import com.example.test_2.service.TuitionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TuitionServiceImplement implements TuitionService
{
    @Autowired
    private TuitionRepository tuitionRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional
    public TuitionEntity addTuition(Long studentId, TuitionEntity tuitionEntity) {
        StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));

        TuitionEntity insertTuition = new TuitionEntity();
        insertTuition.setTuitionId(tuitionEntity.getTuitionId());
        insertTuition.setAmount(tuitionEntity.getAmount());
        insertTuition.setPaymentDate(tuitionEntity.getPaymentDate());
        insertTuition.setPaymentStatus(tuitionEntity.getPaymentStatus());
        insertTuition.setStudentEntity(studentEntity);

        TuitionEntity addTuition = tuitionRepository.save(insertTuition);

        return null;
    }

    @Override
    @Transactional
    public List<TuitionResponse> getAllTuitions() {
        List<TuitionEntity> tuitionEntities = tuitionRepository.findAll();
        return tuitionEntities.stream().map(TuitionResponse::mapToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TuitionResponse FindTuitionById(Long tuitionId) {
        Optional<TuitionEntity> optionalTuition = tuitionRepository.findById(tuitionId);
        return optionalTuition.map(TuitionResponse::mapToResponse).orElse(null);
    }

    @Override
    public void deleteTuitionById(Long tuitionId) {
        tuitionRepository.deleteById(tuitionId);
    }

    @Override
    @Transactional
    public TuitionResponse updateTuition(TuitionRequest tuitionRequest, Long tuitionId){
        TuitionEntity upload =tuitionRepository.findById(tuitionId).orElseThrow(()->new RuntimeException("tuition not found"));

        if(tuitionRequest.getPaymentStatus() != null) {
            upload.setPaymentStatus(tuitionRequest.getPaymentStatus());
        }

        TuitionEntity tuitionEntity = tuitionRepository.save(upload);

        return TuitionResponse.mapToResponse(tuitionEntity);
    }





}
