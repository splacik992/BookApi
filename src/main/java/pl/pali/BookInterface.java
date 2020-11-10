package pl.pali;

import pl.pali.model.Book;

import java.util.List;

public interface BookInterface {
    List<Book> showAll();
    Book getBook(Long id);
    void addBook(Book book);
    void update(Book book);
    void delete(Long id);


}
