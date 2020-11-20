package pl.pali.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.pali.BookService;
import pl.pali.model.Book;
import pl.pali.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Primary
@Repository
public class JpaBookService implements BookService {

    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



    @Override
    public List<Book> showAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBook(Long id) {
        return Optional.empty();
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> getId(Long id) {
        return bookRepository.findById(id);
    }
}
