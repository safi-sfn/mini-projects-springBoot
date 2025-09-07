package in.inxod.studentManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.inxod.studentManagement.model.Student;
import in.inxod.studentManagement.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repo;
	
	@Override
	public List<Student> getAllStudent() {
		
		return repo.findAll();
	}

	@Override
	public Student saveStudents(Student student) {
		
		return repo.save(student);
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> student = repo.findById(id);
		return student.get();
		
	}

	@Override
	public void deleteStudent(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public List<Student> searchByCourseName(String course) {
		
		return repo.findByCourse(course);
	}

}
