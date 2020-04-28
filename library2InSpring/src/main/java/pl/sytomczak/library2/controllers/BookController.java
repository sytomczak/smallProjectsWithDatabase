package pl.sytomczak.library2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sytomczak.library2.mappings.Book;
import pl.sytomczak.library2.repositories.BookRepository;

@RestController
@RequestMapping("books")
public class BookController {

    private BookRepository repository;

    @Autowired
    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getBook")
    public Book getBookById(@RequestParam Integer bookId){
        return (Book)repository.findById(bookId).orElseGet(null);
    }

    @PostMapping("/addBook")
    public void addBook(@RequestBody Book book){
        repository.save(book);
    }


}