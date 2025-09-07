package in.inxod.studentManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.inxod.studentManagement.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	// Custom finder Method
	
	List<Student>findByCourse(String course);
}
