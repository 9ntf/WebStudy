package com.example.webstudy.repository;

import com.example.webstudy.model.User;
import com.example.webstudy.parser.FileParser;
import org.springframework.stereotype.Repository;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class FileRepository {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh-mm-ss");
    private final File dir = new File("D:" + File.separator + "Java" + File.separator + "Projects"
            + File.separator + "webstudy" + File.separator + "files");
    private final FileParser fileParser = new FileParser();

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

    //Получаем запрос на чтение пользователя из файла и возвращаем JSON
    public String getUserFromFile(String fileName) {
        String file = dir + File.separator + fileName + ".xml";
        List<User> users = FileParser.parseXML(file);
        return fileParser.listToJson(users);
    }

}