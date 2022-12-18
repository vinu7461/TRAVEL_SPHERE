package com.travel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer feedbackId;
    private Integer userId;
    private String feedback;
    private Integer rating;
    private LocalDate submitDate;
}
