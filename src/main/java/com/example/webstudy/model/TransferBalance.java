package com.example.webstudy.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferBalance {
    private Long from;
    private Integer to;
    private BigDecimal amount;
}
