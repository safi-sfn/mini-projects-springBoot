package in.inxod.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.inxod.hcl.entity.Patient;
import in.inxod.hcl.service.HospitalService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private HospitalService patientService;
	
	//============PATIENT-RELATED================
	
		@PostMapping("/add/{id}")
		public ResponseEntity<Patient> addPatient(@RequestBody Patient patient, @PathVariable("id")Integer doctorId) {
			Patient newPatient =  patientService.addPatient(patient,doctorId);
			return new ResponseEntity<Patient>(newPatient, HttpStatus.CREATED);
		}
		@GetMapping("/getAll")
		public ResponseEntity<List<Patient>> getAllPatient(){
			List<Patient> patients = patientService.getAllPatients();
			return new ResponseEntity<List<Patient>>(patients,HttpStatus.OK);
		}
		
}
