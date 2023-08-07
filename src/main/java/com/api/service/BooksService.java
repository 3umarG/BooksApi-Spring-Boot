package com.api.service;


import com.api.exceptions.NotFoundBookCustomException;
import com.api.interfaces.BaseRepository;
import com.api.interfaces.BaseBooksService;
import com.api.models.Book;
import com.api.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService extends BaseBooksService {

    private final BaseRepository<Book> repository;

    @Autowired
    public BooksService(BooksRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Book> getAllBooks() {
        return repository.getAll();
    }

    @Override
    public void addBook(Book book) {
        repository.add(book);
    }

    @Override
    public List<Book> searchBook(String query) {
        return repository.search(query);
    }

    @Override
    public Book getBookById(int id) throws NotFoundBookCustomException {
        return repository.getById(id);
    }
}
