package com.librarymngmnt.dto;

import com.librarymngmnt.entities.Student;


import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class BookDTO {
	@NotNull(message="Id cannot be null")
	private Integer Id;
	@Size(min=4,max=10,message="invalid user name")	  
	@NotBlank(message="Please enter the name")
	private String Name;
    @NotEmpty(message = "Author name cannot empty")
	private String Author;
    @NotBlank(message = "Yearofpublication cannot be empty")
    private String YearOfPublication;
	@NotNull(message = "Bookprice cannot be null")
	private String price;
	
	

}
