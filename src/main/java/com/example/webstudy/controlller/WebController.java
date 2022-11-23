package com.example.webstudy.controlller;

import com.example.webstudy.model.Setting;
import com.example.webstudy.model.User;
import com.example.webstudy.service.WebService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@AllArgsConstructor
public class WebController {
    private final WebService webService;

    @PostMapping(
            value = "/savebody",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void saveBody(@RequestBody String body){
        webService.saveBodyRequest(body);
    }

//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        User persistedUser = userService.save(user);
//        return ResponseEntity.created(URI.create(String.format("/users/%s", user.toString())))
//                .body(persistedUser);
//    }
}
