package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lib.model.Book;
import lib.repository.BookRepository;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    // Endpoint per ottenere tutti i libri
    @GetMapping("/")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Endpoint per ottenere un libro per ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    // Endpoint per creare un nuovo libro
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // Endpoint per aggiornare un libro esistente
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            return bookRepository.save(book);
        }
        return null;
    }

    // Endpoint per eliminare un libro
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
    
    @GetMapping("/api/books/test")
    public String testEndpoint() {
        return "Test Endpoint Reached";
    }

}
