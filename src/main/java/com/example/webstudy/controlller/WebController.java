package com.example.webstudy.controlller;

import com.example.webstudy.model.User;
import com.example.webstudy.service.WebService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@AllArgsConstructor
public class WebController {

    private final WebService webService;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "id", defaultValue = "World") Long id) {
        return String.format("Hello %s!" , webService.getUser(id).getName());
    }

    @PostMapping(
            value = "/createuser",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> createUser(@RequestBody User user){
        User persistedUser = webService.save(user);
        return ResponseEntity.created(URI.create(String.format("/users/%s", user.toString())))
                .body(persistedUser);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e) {
        return "ERROR: " + e.getMessage();
    }

}
