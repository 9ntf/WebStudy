package com.example.webstudy.repository;

import com.example.webstudy.model.Setting;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class FileRepository {
    private Date date = new Date();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh.mm.ss");
    private File dir = new File("D:" + File.separator + "Java" + File.separator + "Projects"
            + File.separator + "webstudy" + File.separator + "files");

    public boolean saveInToFile(String message) {
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