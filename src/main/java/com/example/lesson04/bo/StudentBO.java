package com.example.lesson04.bo;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	
	@Autowired
	private StudentMapper studentMapper; // mybatis
	
	@Autowired
	private StudentRepository studentRepository; // JPA
	
	// mybatis
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
	// JPA
	// input : 파라미터들
	// output : StudentEntity (방금 insert되었던 내용)
	public StudentEntity addStudent(String name, String phoneNumber
			, String email, String dreamJob) {
		StudentEntity student = StudentEntity.builder()
				.name(name).phoneNumber(phoneNumber).email(email).dreamJob(dreamJob)
				.createdAt(ZonedDateTime.now()) // @UpdateTimestamp가 있으면 생략 가능
				.build();
		studentRepository.save(student);
		return studentRepository.save(student);
	}
	
}
