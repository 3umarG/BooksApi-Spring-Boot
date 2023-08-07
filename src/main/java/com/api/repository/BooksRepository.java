package com.api.repository;

import com.api.exceptions.NotFoundBookCustomException;
import com.api.interfaces.BaseRepository;
import com.api.models.Book;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BooksRepository implements BaseRepository<Book> {
    private static List<Book> books = new LinkedList<>();


    public List<Book> getAll() {
        return books;
    }

    public void add(Book item) {
        books.add(item);
    }

    public List<Book> search(String query) {
        return books.stream()
                .filter(b -> b.getAuthor().contains(query) || b.getTitle().contains(query))
                .collect(Collectors.toList());
    }

    public Book getById(int id) throws NotFoundBookCustomException {
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new NotFoundBookCustomException("There is no book with that ID")
                );
    }
}
