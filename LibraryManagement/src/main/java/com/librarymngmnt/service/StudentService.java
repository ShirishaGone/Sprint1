package com.librarymngmnt.service;


import java.util.List;

import com.librarymngmnt.dto.BookDTO;
import com.librarymngmnt.dto.StudentDTO;
import com.librarymngmnt.entities.Student;

public interface StudentService {
    public Student saveStudent(StudentDTO studentDTO);
	public Student getStudentById(int studentId);
	public List<Student> displayAll();
	public String updateStudent(int studentId,StudentDTO studentDTO);
	public String deleteStudentById(int studentId);
	public String deleteAllStudents();
}