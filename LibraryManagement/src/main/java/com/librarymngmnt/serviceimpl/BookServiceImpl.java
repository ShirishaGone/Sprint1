package com.librarymngmnt.serviceimpl;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarymngmnt.dto.BookDTO;
import com.librarymngmnt.repository.BookRepository;
import com.librarymngmnt.service.BookService;

import jakarta.persistence.Id;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	
    BookRepository  bookRepository;
	
	@Override
	public Book saveBook(BookDTO bookDTO) {
		Book book=Book.builder().name(bookDTO.getName()).author(bookDTO.getAuthor()).yearofpublication(bookDTO.getYearOfPublication()).price(bookDTO.getPrice).build();
		return bookRepository.save(book);
		
	}

	@Override
	public Book getBookById(int bookId) {
		return bookRepository.findById(bookId).get();
	}

	@Override
	public List<Book> displayAll() {
		return bookRepository.findAll();
	}


	@Override
	public String updateBook(BookDTO params, int bookId) {
	Book book=bookRepository.findById(bookId).get();
		book.setName(params.getName());
		book.setAuthor(params.getAuthor());
		book.setYearOfPublication(params.getYearOfPublication());
		book.setPrice(params.getPrice());
	    bookRepository.save(book);
	    return "updated successfully";
	}

	@Override
	public String deleteBookById(int bookId) {
		bookRepository.deleteById(bookId);
		return "The book id is deleted"+bookId;
	}

	@Override
	public String deleteAllBooks() {
		bookRepository.deleteAll();
		return "Deleted successfully";
	}
			}
    