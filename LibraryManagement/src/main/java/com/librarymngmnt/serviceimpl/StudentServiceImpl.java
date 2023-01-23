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
	public Student saveStudent(StudentDTO studentDTO) {
		Student student=Student.builder()
				.studentName(studentDTO.getStudentName())
				.studentAge(studentDTO.getStudentAge())
				.studentContactNumber(studentDTO.getContactNumber())
				.build();
			return studentRepository.save(student);
	}

	
	public String deleteStudent(Integer id) {
		studentRepository.deleteById(id);
		return "Deleted one record successully";
	}

	
	public String updateStudent(StudentDTO studentDTO, Integer id) {
		Student student=studentRepository.findById(id).get();
		Student student1=Student.builder()
				.studentName(studentDTO.getStudentName())
				.studentAge(studentDTO.getStudentAge());
				.studentContactNumber(studentDTO.getContactNumber());
				.build();
		studentRepository.save(student);
		return "Updated successfully";
	}

	
	public Student getStudentById(Integer id) {
		
		return studentRepository.findById(id).get();
	}

	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
		
	}

	
	public String deleteAllStudents() {
		
		 studentRepository.deleteAll();
		 return "Deleted successfully";
	}
}


	