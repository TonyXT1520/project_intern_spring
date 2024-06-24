package com.example.test_2.response;

import com.example.test_2.entity.TuitionEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TuitionResponse {
    private Long tuitionId;
    private Double amount;
    private String paymentDays;
    private String paymentStatus;

    public TuitionResponse(Long tuitionId, Double amount, String paymentDays, String paymentStatus) {
        this.tuitionId = tuitionId;
        this.amount = amount;
        this.paymentDays = paymentDays;
        this.paymentStatus = paymentStatus;
    }

    public static TuitionResponse mapToResponse(TuitionEntity tuitionEntity){

        return new TuitionResponse(tuitionEntity.getTuitionId(), tuitionEntity.getAmount(), tuitionEntity.getPaymentDate(),tuitionEntity.getPaymentStatus());
    }
}
