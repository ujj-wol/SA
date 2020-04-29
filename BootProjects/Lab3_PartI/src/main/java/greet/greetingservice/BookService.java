package greet.greetingservice;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(String isbn) {
        bookRepository.deleteById(isbn);
    }

    public Book getBook(String isbn) {
        return bookRepository.findById(isbn).get();
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
