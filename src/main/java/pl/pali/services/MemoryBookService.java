package pl.pali.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.pali.BookInterface;
import pl.pali.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MemoryBookService implements BookInterface {

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

    public List<Book> memoryGetBooks() {
        return new ArrayList<>(books);
    }

    public Book memoryUpdateBook(Long id, String isbn, String author, String publisher, String type) {
        Book book = null;
        for (Book bookToUpdate : books) {
            if (bookToUpdate.getId().equals(id)) {
                bookToUpdate.setAuthor(author);
                bookToUpdate.setIsbn(isbn);
                bookToUpdate.setPublisher(publisher);
                bookToUpdate.setType(type);
                book = bookToUpdate;
            } else {
                throw new NoSuchElementException("Book is not exist!");
            }
        }
        return book;
    }

    public Book memoryAddBook() {
        Book newbook = new Book();
        for (Book book : books) {
            if (book.getId().equals(newbook.getId())) {
                System.out.println("false");
            } else {
                books.add(newbook);
            }
        }
        return newbook;
    }

    @Override
    public List<Book> showAll() {
        return null;
    }

    @Override
    public Book getBook(Long id) {
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
}
