package com.example.webstudy.repository;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class FileRepository {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh-mm-ss");
    private final File dir = new File("D:" + File.separator + "Java" + File.separator + "Projects"
            + File.separator + "webstudy" + File.separator + "files");

    //Метод сохряняет тело запроса в файл
    public boolean saveInToFile(String message) {
        Date date = new Date();
        String fileName = dateFormat.format(date) + ".txt";
        File file = new File(dir, fileName);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(message);
            fileWriter.flush();
            return true;
        } catch (IOException ex) {
            System.out.println("Не получилось сохранить в файл");
            return false;
        }
    }
}