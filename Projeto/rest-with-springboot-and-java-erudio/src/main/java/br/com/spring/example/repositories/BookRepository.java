package br.com.spring.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.example.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

}
