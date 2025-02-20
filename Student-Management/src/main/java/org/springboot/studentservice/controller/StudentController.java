package org.springboot.studentservice.controller;

import java.util.List;
import java.util.Optional;

import org.springboot.studentservice.dto.ResponseStructure;
import org.springboot.studentservice.dto.Student;
import org.springboot.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping(value = "/saveStudent")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student){
		return studentService.saveStudent(student);
	}
	
	@GetMapping(value = "/getAllStudenet")
	public ResponseEntity<ResponseStructure<List<Student>>> getAllStudent(){
		return studentService.getAllStudent();
	}
	
	@GetMapping(value = "/getById/{id}")
	public ResponseEntity<ResponseStructure<Optional<Student>>> findById(@PathVariable int id){
		return studentService.findById(id);
		
	}
	
	@PostMapping(value = "/verifyByEmail")
	public ResponseEntity<ResponseStructure<Optional<Student>>> verifyByEmailAndPassword(@RequestParam String email, @RequestParam String password){
		return studentService.verifyByEmailAndPassword(email, password);
	}
	
	@DeleteMapping(value = "/deleteById/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteStudentById(@PathVariable int id){
		return studentService.deleteStudentById(id);
	}

	
	
	
	
	
}

























