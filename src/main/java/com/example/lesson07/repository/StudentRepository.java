package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson07.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	
	// Spring Data JPA : JpaRepository
	
	// save(객체) - insert(기존 id가 없을때), update(기존 id가 있을때) 알아서 해줌
	// findById() - select
	// delete(객체) - delete 
	// findAll() - select *
	
	// JPQL 문법 - ex02/1
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	public List<StudentEntity> findByName(String name);
	public List<StudentEntity> findByNameIn(List<String> names);
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	public List<StudentEntity> findByEmailContains(String keyword);
	public List<StudentEntity> findByNameStartingWith(String parameter);	
	public List<StudentEntity> findByIdBetween(int start, int end);	
	
	// ex02/2
	// 1) JPQL 엔티티로 조회
	// @Query(value="select st from new_student st where st.dreamJob = :dreamJob")
	
	// 2) Native query로 조회
	@Query(value="select * from `new_student` where dreamJob = :dreamJob", nativeQuery=true)
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);
}
