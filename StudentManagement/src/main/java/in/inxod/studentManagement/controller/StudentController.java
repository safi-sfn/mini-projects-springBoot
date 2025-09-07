package in.inxod.studentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.inxod.studentManagement.model.Student;
import in.inxod.studentManagement.service.StudentServiceImpl;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentServiceImpl service;
	
//	Show all students
	@GetMapping()
	public String showAllStudents(Model model) {
		List<Student> students = service.getAllStudent();
		model.addAttribute("allStudent", students);
		return "studentDashboard";
	}
	
//	Show add form
	@GetMapping("/new")
	public String showAddForm(Model model) {
		Student st = new Student();
		model.addAttribute("student", st);
		return "studentForm";
	}
	

//	Save student (new or update)
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudents(student);
		
		return "redirect:/students";
	}

//  REST API (Postman/JSON) ke liye
	@PostMapping("/api/save")
	@ResponseBody
	public Student saveStudentFromApi(@RequestBody Student student) {
	    return service.saveStudents(student);
	}

	
//   Edit student
	@GetMapping("/edit") // using Request param for id
	public String editStudent(@RequestParam("id") Integer id,Model model) {
      Student std =  service.getStudentById(id);
      model.addAttribute("student", std);
		return "studentForm";
	}
	
	
//  Delete Student
	@GetMapping("/delete/{id}")  // Using Path Variable
	public String deleteStudent(@PathVariable("id") Integer id) {
		service.deleteStudent(id);
		return "redirect:/students";
	}
	

//	Search By Course
	@GetMapping("/search")
	public String searchByCourse(@RequestParam("course")String course,Model model) {
		List<Student> stByCourse = service.searchByCourseName(course);
		 if (stByCourse == null || stByCourse.isEmpty()) {
		        model.addAttribute("message", "No students found for course: " + course);
		    } else {
		        model.addAttribute("allStudent", stByCourse);
		    }
		return "studentDashboard";
	}
	
	
	
	
	
	
}


/*
 *
GET /students → Show all students (studentDashboard.jsp)

GET /students/new → Show add form

POST /students/save → Save student (new or update)

GET /students/edit/{id} → Edit form

GET /students/delete/{id} → Delete student
 * 

 */
