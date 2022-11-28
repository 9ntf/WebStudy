package com.example.webstudy.service;

import com.example.webstudy.repository.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WebService {
    FileRepository fileRepository;

    //Сохранение тела запроса
    public void saveBodyRequest(String message){
        fileRepository.saveInToFile(message);
    }
}
