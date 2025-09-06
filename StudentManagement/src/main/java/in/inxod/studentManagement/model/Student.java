package in.inxod.studentManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private Integer id;
	
	@Column(name="student_name")
	private String name;
	
	@Column(name="student_age")
	private Integer age;
	
	@Column(name="student_city")
	private String city;
	
	@Column(name="course")
	private String course;

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}

	

	public Student(String name, Integer age, String city, String course) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.course = course;
	}


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
