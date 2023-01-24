package com.librarymngmnt.service;


import java.awt.print.Book;
import java.util.List;


import com.librarymngmnt.dto.BookDTO;
import com.librarymngmnt.dto.StudentDTO;
import com.librarymngmnt.entities.Student;

public interface StudentService {
     Student saveStudent(StudentDTO studentDTO);
	 Student getStudentById(int studentId);
	 public List<Student>displayAll();
	 public String updateStudent(int studentId,StudentDTO params);
	 public String deleteStudentById(int studentId);
	 public String deleteAllStudents();
}