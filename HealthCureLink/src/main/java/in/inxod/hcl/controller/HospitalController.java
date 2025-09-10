package in.inxod.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.inxod.hcl.entity.Doctor;
import in.inxod.hcl.entity.Patient;
import in.inxod.hcl.service.HospitalServiceImpl;

@RestController
@RequestMapping("/v1")
public class HospitalController {

	@Autowired
	private HospitalServiceImpl hospitalService;
	
	
	//============DOCTOR-RELATED=================
	
	@PostMapping("/add-doctor")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return hospitalService.addDoctor(doctor);
	}
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctor(){
		return hospitalService.getAllDoctor();
	}
	
	//============PATIENT-RELATED================
	
	@PostMapping("/add-patient")
	public Patient addPatient(@RequestBody Patient patient) {
		return hospitalService.addPatient(patient);
	}
	@GetMapping("/patients")
	public List<Patient> getAllPatient(){
		return hospitalService.getAllPatient();
	}
	
	
	//============APPOINTMENT-RELATED============
}
