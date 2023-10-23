package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

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
	
	// input : id, dreamJob
	// output : StudentEntity (변경된 행)
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		StudentEntity student = studentRepository.findById(id).orElse(null);
		if (student != null) {
			// 기존 값은 유지하고 세팅된 일부의 값만 변경(dreamJob만 변경) => toBuilder
			student =  student.toBuilder().dreamJob(dreamJob).build();
			
			// update
			student = studentRepository.save(student); // db update 후 다시 불려온 student
		}
		return student; // null or 변경된 데이터
	}
	
	// input : id
	// output void
	public void deleteStudentById(int id) {
		// 방법 1
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		
		// 방법 2
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s));
	}
}
