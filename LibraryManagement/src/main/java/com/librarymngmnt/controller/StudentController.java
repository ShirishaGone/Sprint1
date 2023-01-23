package com.librarymngmnt.controller;

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

import com.librarymngmnt.dto.StudentDTO;
import com.librarymngmnt.entities.Student;
import com.librarymngmnt.serviceimpl.StudentServiceImpl;

import jakarta.validation.Valid;

@RestController
public class StudentController {
	@Autowired
	StudentServiceImpl studentServiceImpl;
	@PostMapping(path="/students")
	ResponseEntity<Student> insertStudent(@RequestBody @Valid StudentDTO studentDTO) {
		
		return new ResponseEntity<> (studentServiceImpl.saveStudent(studentDTO),HttpStatus.CREATED);
		
	}
	
	@GetMapping(path="/student/{studentId}")
	 public ResponseEntity<Student> getStudentById(@PathVariable Integer studentId)
	{
		return new ResponseEntity<>(studentServiceImpl.getStudentById(studentId),HttpStatus.OK);
	}
	@GetMapping(path="/students")
	public ResponseEntity<List<Student>> getAllStudents()
	{
		return new ResponseEntity<>(studentServiceImpl.getAllStudents(),HttpStatus.OK);
	}
	@PutMapping(path="/students/{studentId}")
	 public ResponseEntity<String> updateStudent(@RequestBody @Valid StudentDTO studentDTO , @PathVariable Integer studentId)
		{
		 return new ResponseEntity<>(studentServiceImpl.updateStudent(studentDTO, studentId),HttpStatus.CREATED);
		}
	 @DeleteMapping(path="/student/{studentId}")
	 public ResponseEntity<String> deleteStudent(@PathVariable Integer studentId)
		{
		 
		 return new ResponseEntity<>(studentServiceImpl.deleteStudent(studentId),HttpStatus.OK);
		}
	 @DeleteMapping(path="/students")
	 public ResponseEntity<String> deleteAllStudents()
	 {
		 return new ResponseEntity<>(studentServiceImpl.deleteAllStudents(),HttpStatus.OK);
	 }
	 
	 
	 
}
