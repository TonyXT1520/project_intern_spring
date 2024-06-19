package com.example.test_2.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
