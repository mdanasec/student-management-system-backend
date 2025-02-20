package org.springboot.studentservice.service;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springboot.studentservice.dao.StudentDao;
import org.springboot.studentservice.dto.ResponseStructure;
import org.springboot.studentservice.dto.Student;
import org.springboot.studentservice.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student){
		ResponseStructure<Student> structure = new ResponseStructure<>();
		structure.setMessage("Student saved Sucessfully");
		structure.setData(studentDao.saveStudent(student));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.CREATED);
	}
		
	public ResponseEntity<ResponseStructure<List<Student>>> getAllStudent(){
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> recStudent= studentDao.getAllStudent();
		if(recStudent.size()>0) {
			structure.setMessage("Student Fund");
			structure.setData(recStudent);
			structure.setStatusCode(HttpStatus.OK.value());
		}
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Optional<Student>>> findById(int id){
		ResponseStructure<Optional<Student>> structure = new ResponseStructure<>();
		Optional<Student> recStudent= studentDao.findById(id);
		
		if(recStudent.isPresent()) {
			structure.setMessage("Student found");
			structure.setData(recStudent);
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Optional<Student>>>(structure, HttpStatus.ACCEPTED);
		}
		throw new StudentNotFoundException("Student Not Found");
		
	}
	
//	verifyByEmailAndPassword
	public ResponseEntity<ResponseStructure<Optional<Student>>> verifyByEmailAndPassword(String email, String password){
		ResponseStructure<Optional<Student>> structure = new ResponseStructure<>();
		Optional<Student> recStudent = studentDao.verifyByEmailAndPassword(email, password);
		
		if(recStudent.isPresent()) {
			structure.setMessage("Log in Sucessfully");
			structure.setData(recStudent);
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Optional<Student>>>(structure, HttpStatus.OK);
		}
		throw new StudentNotFoundException("Invalid Email and password");
	}
	
	
//	deleteStudentById
	public ResponseEntity<ResponseStructure<String>> deleteStudentById(int id){
		ResponseStructure<String> structure= new ResponseStructure<>();
		Optional<Student> recStudent = studentDao.findById(id);
		
		if(recStudent.isPresent()) {
			studentDao.deleteStudentById(id);
			structure.setMessage("Student Details Deleted Sucessfully");
			structure.setData("Student Found");
			structure.setStatusCode(HttpStatus.NO_CONTENT.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NO_CONTENT);
		}
		throw new StudentNotFoundException("Student Not Found");
	}

}












































