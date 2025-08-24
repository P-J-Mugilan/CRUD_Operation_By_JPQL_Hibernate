package com.crud.jpql.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.crud.jpql.entity.Student;

import jakarta.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	
	@Modifying
	@Transactional
	@Query("delete from Student st where st.studentEmailId = :studentEmailId")
	int deleteByStudentEmailId(@Param("studentEmailId") String studentEmailId);
	
	@Modifying
	@Transactional
	@Query("delete from Student st where st.studentId = :studentId")
	int deleteByStudentId(@Param("studentId") long studentId);
	
	@Modifying
	@Transactional
	@Query("update Student s set s.studentName = :sn where s.studentId = :studentId")
	int updateByStudentIdUpdateName(@Param("studentId") long studentId, @Param("sn") String sn);
	
	@Query("select s from Student s where s.studentId=:studentId")
	Optional<Student> readStudent(@Param("studentId") long studentId);
	
	

}
