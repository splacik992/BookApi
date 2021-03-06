package pl.pali.services;

import org.springframework.stereotype.Service;
import pl.pali.BookService;
import pl.pali.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemoryBookService implements BookService {

    List<Book> books;
    private static Long nextId = 4L;

    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "384283483", "Rudowlosa",
                "Marek Juczak", "Helion", "horror"));
        books.add(new Book(2L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming"));
        books.add(new Book(3L, "9780130819338",
                "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
        books.add(new Book(4L, "9788324627738", "Rusz	glowa	Java.",
                "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));

    }

    @Override
    public List<Book> showAll() {
        return new ArrayList<>(books);
    }

    @Override
    public Optional<Book> getBook(Long id) {
        Book book = null;
        for (Book books : books) {
            if (books.getId().equals(id)) {
                book = books;
            }
        }
        return book;
    }

    @Override
    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    @Override
    public void update(Book book) {
        if (this.getId(book.getId()).isPresent()) {
            int indexOf = books.indexOf(this.getId(book.getId()).get());
            books.set(indexOf, book);
        }
    }

    @Override
    public void delete(Long id) {
        books.removeIf(book1 -> book1.getId().equals(id));
    }

    @Override
    public Optional<Book> getId(Long id) {
            return books.stream().filter(item -> item.getId().equals(id)).findFirst();

    }
}
