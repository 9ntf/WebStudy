package com.example.webstudy.model;

import com.example.webstudy.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "serial")
    private Long id;
    @Column(name = "date")
    private String date;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "amount")
    private BigDecimal amount;

    @Override
    public String toString() {
        return String.format(
                "Order: [id=%d, date = '%s', user id = '%d', product_name='%s', amount ='%s']",
                id, date, userId, productName, amount);
    }
}
