package org.springboot.studentservice.repository;

import java.util.Optional;

import org.springboot.studentservice.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Query("SELECT s FROM Student s WHERE s.email = :email AND s.password = :password")
    Optional<Student> verifyByEmailAndPassword(String email, String password);

}
