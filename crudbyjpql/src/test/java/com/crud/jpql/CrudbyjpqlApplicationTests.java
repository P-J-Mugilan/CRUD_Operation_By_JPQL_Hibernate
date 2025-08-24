package com.crud.jpql;


import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.crud.jpql.entity.Student;
import com.crud.jpql.repository.StudentRepository;



@SpringBootTest
class CrudbyjpqlApplicationTests {
	
	@Autowired
	StudentRepository studentRepository;
	
	Student student;
	
	@BeforeEach
	public void beanCreation() {
		student = new Student();
	}
	
	@AfterEach
	public void testSuccess() {
		System.out.println("Test Completed");
	}
	
	@Test
	void addStudent() {
		student.setStudentId(1034);
		student.setStudentName("midhun");
		student.setStudentEmailId("midhun@gmail.com");
		student.setStudentMobile("8574961246");
		student.setDepartment("mca");
		
		studentRepository.save(student);
	}
	
	@Test
	void readStudentByJPQL() {
		Optional<Student> student= studentRepository.readStudent(1011);
		
		if(student.isPresent()) {
			System.out.println("Student Id : "+student.get().getStudentId());
			System.out.println("Student Name : "+student.get().getStudentName());
			System.out.println("Student Mobile No : "+student.get().getStudentMobile());
			System.out.println("Student Email Id : "+student.get().getStudentEmailId());
			System.out.println("Student Department : "+student.get().getDepartment());
		} else {
			System.out.println("User is Empty");
		}
	}
	
	@Test
	void deleteStudent() {
		int rowEffected = studentRepository.deleteByStudentId(1034);
		System.out.println(rowEffected);
	}
	
	
	@Test
	void updateByStudentIdByJPQL() {
		Optional<Student> student = studentRepository.readStudent(1011);
		int updateStudent= studentRepository.updateByStudentIdUpdateName(1011, "vijay");
		
		if(student.isPresent()) {
			System.out.println(updateStudent +" is got effected");
		} else {
			System.out.println("User Not Found");
		}
	}

}
