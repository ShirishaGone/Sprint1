package com.librarymngmnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.librarymngmnt.dto.StudentDTO;
import com.librarymngmnt.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	

}
