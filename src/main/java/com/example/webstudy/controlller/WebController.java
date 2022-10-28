package com.example.webstudy.controlller;

import com.example.webstudy.model.TransferBalance;
import com.example.webstudy.service.WebService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController("/web")
@AllArgsConstructor
public class WebController {

    private final WebService webService;

    @GetMapping("/{id}")
    public BigDecimal getHello(@PathVariable int id){
        return webService.getBalance(id);
    }

    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody TransferBalance amount){
        return webService.addMoney(amount.getTo(), amount.getAmount());
    }

    @PostMapping("/transfer")
    public void transferMoney(
            @PathVariable int id,
            @RequestBody BigDecimal amount) {
        webService.transferMoney(id, amount);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e){
        return "ERRRROOOORRRR";
    }

}
