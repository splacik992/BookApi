package pl.pali.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.pali.BookService;
import pl.pali.model.Book;

import java.util.List;

@Controller
@RequestMapping("admin/books")
public class ManageBookController {

    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/all")
    public String showPosts(Model model){
        List<Book> bookList = bookService.showAll();
        model.addAttribute("books",bookList);

        return "/books/all";
    }
}
