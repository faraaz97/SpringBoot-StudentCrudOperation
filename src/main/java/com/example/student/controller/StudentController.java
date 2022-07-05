package com.example.student.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.student.entity.Student;
import com.example.student.exception.IdNotFoundException;
import com.example.student.exception.ResponseNotFoundException;
import com.example.student.service.StudentService;


@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/create")
	public ResponseEntity<String> createStudent(@RequestBody Student student){
		service.createStudent(student);
		return ResponseEntity.ok("Student Created!");
		}
	@GetMapping("/{name}")
	public ResponseEntity<Student> getStudent(@PathVariable String name) {
	Student student = service.getStudentByName(name);
	if(student==null) {
		throw new ResponseNotFoundException();
	}
		return ResponseEntity.ok(student);
	}
	@PutMapping("/update/{name}")
	public Student updateStudent(@RequestBody Student student, @PathVariable String name) {
		return service.updateId(name,student);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable Long id) {
		service.deleteById(id);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Student>>getAll(){
		List<Student> listStudents = service.getAll();
		return new ResponseEntity<List<Student>>(listStudents,HttpStatus.OK);
	}

}
