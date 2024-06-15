package com.example.test_2.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TuitionResponse {
    private Integer tuitionId;
    private Double amount;
    private String paymentStatus;
    private String paymentDate;

}
