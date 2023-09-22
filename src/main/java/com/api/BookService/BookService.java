package com.api.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.BookEntity.Book;
import com.api.BookRepository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
	

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.orElse(null);
    }

    public Book createBook(Book book) {
        // Perform any necessary validations or business logic
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        // Check if the book with the given ID exists
        if (bookRepository.existsById(id)) {
            updatedBook.setId(id);
            return bookRepository.save(updatedBook);
        }
        return null; // Book not found
    }

    public boolean deleteBook(Long id) {
        // Check if the book with the given ID exists
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true; // Deletion successful
        }
        return false; // Book not found, deletion failed
    }
}
