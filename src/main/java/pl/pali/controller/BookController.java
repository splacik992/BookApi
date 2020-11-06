package pl.pali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pali.model.Book;
import pl.pali.services.MemoryBookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private MemoryBookService memoryBookService;

    @Autowired
    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");

    }

    @GetMapping("/{id}")
    public Book getBook (@PathVariable Long id){
        return this.memoryBookService.memoryGetBook(id);
    }
}
