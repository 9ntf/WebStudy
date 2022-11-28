package com.example.webstudy.controlller;

import com.example.webstudy.service.WebService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebController {
    private final WebService webService;

    //Получение тела запроса
    @PostMapping(
            value = "/savebody",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void saveBody(@RequestBody String body){
        webService.saveBodyRequest(body);
    }
}
