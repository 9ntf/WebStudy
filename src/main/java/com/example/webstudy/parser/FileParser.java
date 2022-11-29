package com.example.webstudy.parser;

import com.example.webstudy.model.User;
import com.example.webstudy.model.enums.Role;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

    //Метод читающий из XML
    public static List<User> parseXML(String fileName) {
        List<User> users = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(fileName));
            NodeList nodeList = doc.getElementsByTagName("user");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    Element element = (Element) node;
                    long id = Long.parseLong(element.getElementsByTagName("id").item(0).getTextContent());
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String email = element.getElementsByTagName("email").item(0).getTextContent();
                    Role role = Role.valueOf(element.getElementsByTagName("role").item(0).getTextContent().toUpperCase());
                    String password = element.getElementsByTagName("password").item(0).getTextContent();
                    boolean active = Boolean.parseBoolean(element.getElementsByTagName("active").item(0).getTextContent());
                    users.add(new User(id, name, email, active, password, role));
                }
            }
        } catch (Exception ex) {
            System.out.println("Не получилось считать файл: " + ex.getMessage());
        }
        return users;
    }

    //List to JSON
    public static String listToJson(List list) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type lisType = new TypeToken<List<User>>() {
        }.getType();
        String json = gson.toJson(list, lisType);
        return json;
    }
}
