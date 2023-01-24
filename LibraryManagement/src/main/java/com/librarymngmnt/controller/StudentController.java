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
import com.librarymngmnt.exception.StudentNotFoundException;
import com.librarymngmnt.serviceimpl.StudentServiceImpl;

import jakarta.validation.Valid;

@RestController
public class StudentController {
	@Autowired
	
	StudentServiceImpl studentServiceImpl;
	
	@PostMapping(path="/student")
	ResponseEntity<Student> insertStudent(@RequestBody @Valid StudentDTO studentDTO) {
		try
		{
			Student student=studentServiceImpl.saveStudent(studentDTO);
			 if(student!=null) 
			 {
		       return new ResponseEntity<Student> (student,HttpStatus.CREATED);
			 }
		}
		catch(Exception ex)
		{
			throw new StudentNotFoundException("Not able to handle the student");
		}
		return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(path="/student/{studentId}")
	 public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Integer studentId)
	{
		try {
			Student student=studentServiceImpl.getStudentById(studentId);
			if(student!=null) 
			{
		     return new ResponseEntity<Student>(student,HttpStatus.OK);
			}
		}
		catch(Exception e)
		{
			throw new StudentNotFoundException("No Such student with id "+studentId);
		}
		 return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		
	}
	@GetMapping(path="/allstudents")
	public ResponseEntity<List<Student>> getAllStudents()
	{
		try
		{
		 List<Student> studentList=studentServiceImpl.displayAll();
		 if(studentList!=null)
		  {
		   return new ResponseEntity<>(studentList,HttpStatus.OK);
		  }
		}
		catch(Exception e)
		{
			throw new StudentNotFoundException("Not able to student exist ");
		}
		return new ResponseEntity<List<Student>>(HttpStatus.NOT_FOUND);
	}
	@PutMapping(path="/updatestudents/{studentId}")
	 public ResponseEntity<String> updateStudent(@RequestBody @Valid StudentDTO studentDTO , @PathVariable("studentId")Integer studentId)
	 {
		try
		{
		 String student=studentServiceImpl.updateStudent(studentId, studentDTO);
		 if(student!=null)
		  {
		    return new ResponseEntity<String>(student,HttpStatus.CREATED);
		  }
		}
		catch(Exception e)
		{
			throw new StudentNotFoundException("Not able to update the student");
		}
		  return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);
	 }
	 @DeleteMapping(path="/deleteStudentById/{studentId}")
	 public ResponseEntity<String> deleteStudent(@PathVariable("studentId")Integer studentId)
	 {
		 try 
			{
			 String student=studentServiceImpl.deleteStudentById(studentId);
			 if(student!=null)
			  {
		        return new ResponseEntity<String>(student,HttpStatus.OK);
			  }
			}
			catch(Exception e)
			{
				throw new StudentNotFoundException("Not able to delete the student");
			}
			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);	
	 }
	 @DeleteMapping(path="/deleteAllStudents")
	 public ResponseEntity<String> deleteAllStudents()
	 {
		 try
			{
			 String student=studentServiceImpl.deleteAllStudents();
			 if(student!=null)
			  {
				 return new ResponseEntity<String>(student,HttpStatus.OK);
			  }
			}
			catch(Exception e)
			{
				throw new StudentNotFoundException("Not able to delete the student");
			}
			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
	 }
	 
	 
	 
}
