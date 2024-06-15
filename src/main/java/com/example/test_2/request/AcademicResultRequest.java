package com.example.test_2.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcademicResultRequest {
    private String subject;
    private String score;
    private String semester;
    private String academicResult;
}
