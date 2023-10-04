package lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lib.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}