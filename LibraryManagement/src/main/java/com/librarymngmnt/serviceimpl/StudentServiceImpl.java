package com.librarymngmnt.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.stereotype.Service;

import com.librarymngmnt.dto.StudentDTO;
import com.librarymngmnt.entities.Student;
import com.librarymngmnt.repository.StudentRepository;
import com.librarymngmnt.service.StudentService;

import jakarta.persistence.Id;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student saveStudent(StudentDTO studentDTO) {
		Student student=Student.builder().name(studentDTO.getName()).age(studentDTO.getAge()).contactnumber(studentDTO.getContactNumber()).build();
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(int studentId) {
		return studentRepository.findById(studentId).get();
	}

	@Override
	public List<Student> displayAll() {
		return studentRepository.findAll();
	}

	@Override
	public String updateStudent(int studentId, StudentDTO params) {
		Student student=studentRepository.findById(studentId).get();
		student.studentName(params.getStudentName());
		student.studentAge(params.getStudentAge());
		student.studentContactNumber(params.getContactNumber());
		studentRepository.save(student);
		return "Updated successfully";
			}

	@Override
	public String deleteStudentById(int studentId) {
		studentRepository.deleteById(studentId);
		return "The student id is deleted"+studentId;
	}

	@Override
	public String deleteAllStudents() {
		studentRepository.deleteAll();
		 return "Deleted successfully";
	}
}