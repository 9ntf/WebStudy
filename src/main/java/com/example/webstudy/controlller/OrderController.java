package com.example.webstudy.controlller;

import com.example.webstudy.service.OrderService;
import com.example.webstudy.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    //Получаем список продуктов по пользователю
    @GetMapping("/getOrderByUser")
    public String getOrdersByUser(@RequestParam(value = "name") String name){
        return orderService.getOrderByUser(name);
    }
}
