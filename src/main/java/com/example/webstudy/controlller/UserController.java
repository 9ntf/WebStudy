package com.example.webstudy.controlller;

import com.example.webstudy.model.User;
import com.example.webstudy.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    //Получение пользователя
    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "id", defaultValue = "World") Long id) {
        return String.format("Hello %s!", userService.getUser(id).getName());
    }

    //Создание пользователя из JSON
    @PostMapping(
            value = "/createuser",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User persistedUser = userService.save(user);
        return ResponseEntity.created(URI.create(String.format("/users/%s", user.toString())))
                .body(persistedUser);
    }

    //Получение JSON пользователя из файла
    @GetMapping("/getusersfromfile")
    public String getUserFromFile(@RequestParam(value = "filename") String fileName){
        return userService.getUserFromFile(fileName);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e) {
        return "ERROR: " + e.getMessage();
    }

}
