package com.librarymngmnt.repository;

import java.awt.print.Book;


import org.springframework.data.jpa.repository.JpaRepository;

import com.librarymngmnt.dto.BookDTO;

public interface BookRepository extends JpaRepository<Book, Integer> {

	

}
