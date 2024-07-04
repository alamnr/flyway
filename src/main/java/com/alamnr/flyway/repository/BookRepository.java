package com.alamnr.flyway.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alamnr.flyway.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,String> {
    
}
