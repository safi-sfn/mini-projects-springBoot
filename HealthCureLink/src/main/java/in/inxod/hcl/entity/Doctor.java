package in.inxod.hcl.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer doctorId;
     private String name;
	 private String specialization;
	 private Integer experience;
	 private Double salary;

	 @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	 @JsonIgnoreProperties("doctor")   // patients ke andar doctor ignore karega
	 private List<Patient> patients;

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Doctor(String name, String specialization, Integer experience, Double salary, List<Patient> patients) {
		super();
		this.name = name;
		this.specialization = specialization;
		this.experience = experience;
		this.salary = salary;
		this.patients = patients;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
}
