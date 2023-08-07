package com.api.interfaces;

import com.api.exceptions.NotFoundBookCustomException;
import com.api.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BaseBooksService {
    abstract public List<Book> getAllBooks();

    abstract public void addBook(Book book);

    abstract public List<Book> searchBook(String query) throws NotFoundBookCustomException;

    abstract public Book getBookById(int id) throws NotFoundBookCustomException;
}
