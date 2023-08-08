package com.api.controllers;

import com.api.exceptions.NotFoundBookCustomException;
import com.api.interfaces.BaseBooksService;
import com.api.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BooksThymeleafController {

    private final BaseBooksService service;

    @Autowired
    public BooksThymeleafController(BaseBooksService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String listBooks(Model model) {
        model.addAttribute("books", service.getAllBooks());
        return "listBooks";
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        service.addBook(book);
        return "redirect:/books/list";
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam String query, Model model) throws NotFoundBookCustomException {
        model.addAttribute("books", service.searchBook(query));
        return "searchBooks";
    }

    @GetMapping("/{id}")
    public String viewBook(@PathVariable int id, Model model) {
        try {
            Book book = service.getBookById(id);
            model.addAttribute("book", book);
            return "viewBook";
        } catch (NotFoundBookCustomException ex) {
            return "notFound"; // Create a "notFound.html" template
        }
    }
}

