package com.example.test_2.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TuitionRequest {
    private Double amount;
    private String paymentDate;
    private String paymentStatus;
}
