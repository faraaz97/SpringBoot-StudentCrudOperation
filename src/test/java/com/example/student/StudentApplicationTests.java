package com.example.student;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.example.student.entity.Student;
import com.example.student.repo.StudentRepo;
import com.example.student.service.StudentService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class StudentApplicationTests {
	
	@Autowired
	StudentRepo repo;
	@Autowired
	StudentService service;

	@Test
	@Order(1)
	public void testCreate() {
		Student s = new Student();
		s.setName("faraaz");
		s.setEmail("faraaz@gmail.com");
		Student storedValue = repo.save(s);
		Student st = repo.findById(storedValue.getId()).get();
		assertEquals(st.getName(),storedValue.getName());
	}
	@Test
	@Order(2)
	public void testRead() {
		List<Student> list = repo.findAll();
		int size = list.size();
		assertTrue(size>0);
	}
//	@Test
//	@Order(3)
//	public void testUpdate() {
//		Student s = new Student();
//		s.setName("khanna");
//		s.setEmail("khanna@gmail.com");
//		//Student storedValue = repo.save(s);
//		Student st = service.updateId(s.getName(), s);
//		assertEquals(s.getEmail(),st.getEmail());
		
//	}
	@Test
	@Order(3)
	public void testDelete() {
		Student s = new Student();
		s.setName("zain");
		s.setEmail("zain@gmail.com");
		Student storeValue = repo.save(s);
		repo.deleteById(s.getId());
		Boolean st = repo.findById(s.getId()).isPresent();
		System.out.println(st);
		assertFalse(st);
	}

}
