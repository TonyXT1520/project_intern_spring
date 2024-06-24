package com.example.test_2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tuition")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TuitionEntity {
    @Id
    @Column(name = "tuition_id")
    private Long tuitionId;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "payment_date")
    private String paymentDate;

    @Column(name = "payment_status")
    private String paymentStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "tuition_1"))
    @JsonIgnore
    private StudentEntity studentEntity;
}
