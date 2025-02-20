package org.springboot.studentservice.dao;

import java.util.List;
import java.util.Optional;

import org.springboot.studentservice.dto.Student;
import org.springboot.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
	
	@Autowired
	private StudentRepository  studentRepository;
	
//	Save Student
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
//	get All Student
	public List<Student> getAllStudent(){
		return studentRepository.findAll();
	}
//	Student Find By Id
	public Optional<Student> findById(int id){
		return studentRepository.findById(id);
	}
//	Verify by Email and password
	public Optional<Student> verifyByEmailAndPassword(String email, String password){
		return studentRepository.verifyByEmailAndPassword(email, password);
	}
	
//	Remove Student
	public boolean deleteStudentById(int id) {
		Optional<Student> recProduct = findById(id);
		if (recProduct.isPresent()) {
			studentRepository.delete(recProduct.get());
			return true;
		}
		return false;
	}
}
























