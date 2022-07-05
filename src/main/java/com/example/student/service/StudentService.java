package com.example.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.student.entity.Student;
import com.example.student.repo.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo repo;
	
	public Student createStudent(Student student) {
		student=repo.save(student);
		return student;
	}
	public Student getStudentByName(String name) {
		
		return repo.findByName(name);
	}
	public void deleteById(Long id) {
		Student student=repo.getById(id);
		repo.delete(student);
	}
	public Student updateId(String name, Student student) {
		// TODO Auto-generated method stub
		Student stu=repo.findByName(name);
		stu.setName(student.getName());
		stu.setEmail(student.getEmail());
		repo.save(stu);
		return stu;
	}
	public List<Student> getAll(){
		return repo.findAll();
	}
	

}
