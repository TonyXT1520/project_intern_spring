package com.example.test_2.service.implement;

import com.example.test_2.entity.ClassEntity;
import com.example.test_2.entity.TuitionEntity;
import com.example.test_2.repository.TuitionRepository;
import com.example.test_2.request.TuitionRequest;
import com.example.test_2.response.TuitionResponse;
import com.example.test_2.service.TuitionService;
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

    /*@Override
    public TuitionEntity addTuition(TuitionEntity tuitionEntity) {
        TuitionEntity tuitionEntity1 = new TuitionEntity();
        tuitionEntity1.setAmount(tuitionRequest.getAmount());
        tuitionEntity1.setPaymentDate(tuitionRequest.getPaymentDate());
        tuitionEntity1.setPaymentStatus(tuitionRequest.getPaymentStatus());

        return mapToResponse(savedEntity);
    }*/

    @Override
    public List<TuitionResponse> fetchTuitionList() {
        List<TuitionEntity> tuitionEntities = tuitionRepository.findAll();
        return tuitionEntities.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public TuitionResponse FindTuitionById(Integer tuitionId) {
        Optional<TuitionEntity> optionalTuition = tuitionRepository.findById(tuitionId);
        return optionalTuition.map(this::mapToResponse).orElse(null);
    }

    @Override
    public void deleteTuitionById(Integer tuitionId) {
        tuitionRepository.deleteById(tuitionId);
    }

    private TuitionResponse mapToResponse(TuitionEntity tuitionEntity){
        TuitionResponse tuitionResponse = new TuitionResponse();
        tuitionResponse.setTuitionId(tuitionEntity.getTuitionId());
        tuitionResponse.setAmount(tuitionEntity.getAmount());
        tuitionResponse.setPaymentDate(tuitionEntity.getPaymentDate());
        tuitionResponse.setPaymentStatus(tuitionEntity.getPaymentStatus());

        return tuitionResponse;
    }
}
