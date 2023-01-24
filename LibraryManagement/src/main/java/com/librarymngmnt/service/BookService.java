package com.librarymngmnt.service;

import java.awt.print.Book;

import java.util.List;

import com.librarymngmnt.dto.BookDTO;

public interface BookService {
	 Book saveBook(BookDTO bookDTO);
	 Book getBookById(int bookId);
	 public List<Book>displayAll();
	 public String updateBook(int bookId,BookDTO params);
	 public String deleteBookById(int bookId);
	 public String deleteAllBooks();
}
