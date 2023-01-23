package com.librarymngmnt.dto;

import java.util.List;

import com.librarymngmnt.entities.Student;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class StudentDTO {
	@NotBlank(message = "Id cannot be Blank")
	private Integer Id;
	@NotNull(message = "Name cannot be null")
	@Size(min = 5, max = 10, message = "Name must be within 2-20 characters")
	private String name;
	@NotNull(message = "Age can't be  null")
	private String age;
	@NotBlank(message = "Contact number can't be Blank")
	private String ContactNumber;
   
}
