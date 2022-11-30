package com.example.webstudy.controlller;

import com.example.webstudy.service.WebService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class WebController {
    private final WebService webService;


    //Hello World
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    //Получение тела запроса
    @PostMapping(
            value = "/savebody",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void saveBody(@RequestBody String body) {
        webService.saveBodyRequest(body);
    }
}
