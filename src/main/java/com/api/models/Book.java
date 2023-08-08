package com.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private  int id;
    private  String title;
    private  String author;
    private  String description;
    private  double price;
    private  int quantity;

    public Book(){

    }
}
