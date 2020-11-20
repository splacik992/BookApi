package pl.pali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pali.model.Book;
import pl.pali.services.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final MemoryBookService memoryBookService;

    @Autowired
    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @GetMapping("/books")
    public List<Book> helloBook() {
        return this.memoryBookService.showAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return this.memoryBookService.getBook(id);
    }

    @PostMapping("/add")
    public void newBook(@RequestBody Book book) {
        this.memoryBookService.addBook(book);
    }

    @RequestMapping(value = "/{id}")
    public void deleteBook(@PathVariable Long id){
        this.memoryBookService.delete(id);
    }

    @PutMapping("")
    @ResponseBody
    public void updateBook(@RequestBody Book book) {
        this.memoryBookService.update(book);
    }
}