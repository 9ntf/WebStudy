package com.example.webstudy.service;

import com.example.webstudy.model.User;
import com.example.webstudy.repository.FileRepository;
import com.example.webstudy.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;
    FileRepository fileRepository;

    //Получение пользователя из репозитория
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    //Сохранение пользователя в репозиторий
    public User save(User user) {
        return userRepository.save(user);
    }

    //Возвращаем пользователя из файла
    public String getUserFromFile(String fileName) {
        return fileRepository.getUserFromFile(fileName);
    }
}
