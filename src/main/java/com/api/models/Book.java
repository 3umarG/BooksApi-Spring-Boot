package com.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private final int id;
    private final String title;
    private final String author;
    private final String description;
    private final double price;
    private final int quantity;

}
