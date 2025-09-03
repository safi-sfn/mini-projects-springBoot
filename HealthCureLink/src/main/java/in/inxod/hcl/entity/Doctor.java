package in.inxod.hcl.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Doctor {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer doctorId;
     private String name;
	 private String specialization;
	 private Integer experience;
	 private Double salary;

	 @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	 private List<Patient> patients;
}
