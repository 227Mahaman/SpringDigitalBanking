package com.akoydev.ebanking_backend.dtos;

import java.util.Date;

import com.akoydev.ebanking_backend.enums.OperationType;

import lombok.Data;

@Data
public class AccountOperationDTO {
    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType type;
    private String description;
}
