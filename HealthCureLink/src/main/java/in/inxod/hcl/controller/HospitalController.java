package in.inxod.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
		Doctor newDoctor =  hospitalService.addDoctor(doctor);
		return new ResponseEntity<Doctor>(newDoctor, HttpStatus.CREATED);
	}
	@GetMapping("/doctors")
	public ResponseEntity<List<Doctor>> getAllDoctor(){
		List<Doctor> allDoctors = hospitalService.getAllDoctor();
		return new ResponseEntity<List<Doctor>>(allDoctors, HttpStatus.OK);
	}
	
	
	//============PATIENT-RELATED================
	
	@PostMapping("/add-patient")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
		Patient newPatient =  hospitalService.addPatient(patient);
		return new ResponseEntity<Patient>(newPatient, HttpStatus.CREATED);
	}
	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> getAllPatient(){
		List<Patient> patients = hospitalService.getAllPatient();
		return new ResponseEntity<List<Patient>>(patients,HttpStatus.OK);
	}
	
	
	//============APPOINTMENT-RELATED============
}
