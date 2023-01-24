package com.librarymngmnt.controller;

import java.awt.print.Book;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.librarymngmnt.dto.BookDTO;
import com.librarymngmnt.exception.BookNotFoundException;
import com.librarymngmnt.serviceimpl.BookServiceImpl;

import jakarta.validation.Valid;



@RestController
public class BookController {
	@Autowired
	
	BookServiceImpl bookServiceImpl;
	
	@PostMapping(path="/books")
	ResponseEntity<Book> insertBook(@RequestBody @Valid BookDTO bookDTO) {
		try
		{
			Book book=bookServiceImpl.saveBook(bookDTO);
			 if(book!=null) 
			 {
	           return new ResponseEntity<Book> (book,HttpStatus.CREATED);
			 }
		}
		catch(Exception ex)
		{
			throw new BookNotFoundException("Not able to handle the book");
		}
		return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping(path="/getBookById/{bookId}")
	 public ResponseEntity<Book> getBookById(@PathVariable Integer bookId)
	{
		try {
			Book book=bookServiceImpl.getBookById(bookId);
			if(book!=null) 
			{
		      return new ResponseEntity<Book>(book,HttpStatus.OK);
			}
		}
		catch(Exception e)
		{
			throw new BookNotFoundException("No such book with id "+bookId);
		}
		 return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		
	 }
	
	 @PutMapping(path="/updateBookById/{bookId}")
	 public ResponseEntity<String> updateBook(@RequestBody @Valid BookDTO bookDTO , @PathVariable Integer bookId)
		{
		 try
			{
			 String book=bookServiceImpl.updateBook(bookDTO, bookId);
			 if(book!=null)
			  {
		       return new ResponseEntity<String>(book,HttpStatus.CREATED);
			  }
			}
			catch(Exception e)
			{
				throw new BookNotFoundException("Not update the company details");
			}
			return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);	
		}
	 @DeleteMapping(path="/deleteBookById/{bookId}")
	 public ResponseEntity<String> deleteBook(@PathVariable("bookId") Integer bookId)
		{
		 try 
			{
			 String book=bookServiceImpl.deleteBookById(bookId);
			 if(book!=null)
			   {
				 return new ResponseEntity<String>(book,HttpStatus.OK);
		       }
			}
			catch(Exception e)
			{
				throw new BookNotFoundException("Not deleted the company details");
			}
			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
	 }
}


