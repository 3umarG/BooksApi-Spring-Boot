package com.api.controllers;

import com.api.exceptions.NotFoundBookCustomException;
import com.api.factories.BaseFactory;
import com.api.factories.FailureFactory;
import com.api.factories.SuccessFactory;
import com.api.interfaces.BaseBooksService;
import com.api.models.Book;
import com.api.responses.Response;
import com.api.responses.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    private final BaseBooksService service;

    @Autowired
    public BooksController(BaseBooksService service) {
        this.service = service;
    }


    //    @RequestMapping(method=GET)
    @GetMapping("/")
    public ResponseEntity<Response<List<Book>>> getBooks() {
        BaseFactory<List<Book>> factory = new SuccessFactory<List<Book>>(service.getAllBooks());
        return ResponseEntity.ok(factory.createResponse());
    }


    @PostMapping()
    public ResponseEntity<Response<Book>> addBook(@RequestBody Book book) {
        SuccessFactory<Book> factory = new SuccessFactory<>(book);
        return ResponseEntity.ok(factory.createResponse());
    }

    // api/books/search?query="......"
    @GetMapping("/search")
    public ResponseEntity<Response> searchBooks(@RequestParam String query) {
        try {
            SuccessFactory<List<Book>> factory = new SuccessFactory<>(service.searchBook(query));
            return ResponseEntity.ok(factory.createResponse());
        } catch (NotFoundBookCustomException e) {
            FailureFactory factory = new FailureFactory("There is no such book with that query !!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(factory.createResponse());
        }
    }


    @GetMapping("/{id}") // api/books/1
    public ResponseEntity<Response> getBookById(@PathVariable int id) {
        try {
            Book book = service.getBookById(id);
            SuccessFactory<Book> factory = new SuccessFactory<>(book);
            return ResponseEntity.ok(factory.createResponse());
        } catch (NotFoundBookCustomException ex) {
            FailureFactory factory = new FailureFactory("There is no Book with that ID");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(factory.createResponse());
        }
    }

    /*
    Get Book Authors :
    /api/books/{id}/authors
     */
}
