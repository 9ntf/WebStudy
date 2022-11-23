package com.example.webstudy.model;

import lombok.Data;

@Data
public class Setting {
    private int id;
    private String message;
    private String date;
    private boolean active;
}
