package com.akoydev.ebanking_backend.dtos;

import lombok.Data;

@Data
public class TransferRequestDTO {
    private String accountIdSource;
    private String accountIdDestination;
    private double amount;
}
