package com.example.webstudy.repository;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class WebRepository {
    private final Map<Integer, BigDecimal> storage = new HashMap<Integer, BigDecimal>(Map.of(1, BigDecimal.TEN));

    public BigDecimal getBalanceFromId(int id) {
        return storage.get(id);
    }

    public BigDecimal addMoney(Integer to, BigDecimal amount) {
        BigDecimal currentBalance = storage.get(to);
        if (currentBalance == null){
            storage.put(to, amount);
            return amount;
        } else {
            BigDecimal updatedBalance = currentBalance.add(amount);
            storage.put(to, updatedBalance);
            return updatedBalance;
        }
    }

    public void transfer(int id, BigDecimal amount) {

    }
}
