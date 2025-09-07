package in.inxod.studentManagement.service;

import java.util.List;

import in.inxod.studentManagement.model.Student;

public interface StudentService {
 
	// Getting All Students from DB
	List<Student> getAllStudent();
	
	Student saveStudents(Student student);
	
	Student getStudentById(Integer id);
	
	void deleteStudent(Integer id);
	
	List<Student> searchByCourseName(String course);
}
