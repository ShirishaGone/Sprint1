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
		Book book= Book.builder()
				       .bookId(bookDTO.getBookId())
				       .bookName(bookDTO.getBookName())
				       .bookAuthor(bookDTO.getBookAuthor())
				       .bookYearOfPublication(bookDTO.getBookYearOfPublication())
				       .bookPrice(bookDTO.getBookPrice())
				       .build();
		return bookRepository.save(book);
	}
	public Book getBookById() {
		
		return bookRepository.findById(bookId).get();
	}

	@Override
	public List<Book> displayAll() {
	
		return bookRepository.findAll();
	}

	public String updateBook(BookDTO bookDTO, int bookId) {
		Book book=Book.builder()
	       .bookName(bookDTO.getBookName());
	       .bookAuthor(bookDTO.getBookAuthor());
	       .bookYearOfPublication(bookDTO.getBookYearOfPublication());
	       .bookPrice(bookDTO.getBookPrice());
	       .Student(bookDTO.getStudent())
	       .build();
	       
	       bookRepository.save(book);
		   return"Book record updated successfully" ;
	}

	@Override
	public String deleteBookById(int bookId) {
		bookRepository.deleteById(bookId);
		return "Book record id"+bookId+"deleted successfully";
	}
	@Override
	public String deleteAllBooks() {
		bookRepository.deleteAll();
		return "Deleted successfully";
	}
	
}
