package com.example.webstudy.service;

import com.example.webstudy.model.TransferBalance;
import com.example.webstudy.repository.WebRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class WebService {

    private final WebRepository webRepository;


    public BigDecimal getBalance(int id) {
        BigDecimal balance =  webRepository.getBalanceFromId(id);
        if (balance == null) {
            throw new IllegalArgumentException();
        }
        return balance;
    }

    public void transferMoney(int id, BigDecimal amount) {
        webRepository.transfer(id, amount);
    }

    public BigDecimal addMoney(Integer to, BigDecimal amount) {
        return webRepository.addMoney(to, amount);
    }
}
