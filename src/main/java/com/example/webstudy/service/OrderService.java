package com.example.webstudy.service;

import com.example.webstudy.repository.OrderRepository;
import com.example.webstudy.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    OrderRepository orderRepository;
    UserRepository userRepository;

    //Поиск заказов по имени
    public String getOrderByUser(String name) {
        Long id = userRepository.findByName(name).get().getId();
        String user = userRepository.findByName(name).get().getName();
        String order = orderRepository.findById(id).get().toString();
        return "Name: " + user + " " + order;
    }
}
