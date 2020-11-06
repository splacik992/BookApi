package pl.pali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pali.model.Book;
import pl.pali.services.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private MemoryBookService memoryBookService;

    @Autowired
    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @GetMapping("/books")
    public List<Book> helloBook() {
        return this.memoryBookService.memoryGetBooks();

    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return this.memoryBookService.memoryGetBook(id);
    }

    @PostMapping()
    public Book newBook() {

        Book book = new Book();
        return book;
    }


}
