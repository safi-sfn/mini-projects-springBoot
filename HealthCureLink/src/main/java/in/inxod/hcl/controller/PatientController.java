package in.inxod.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
		
		@PatchMapping("/update/{id}")
		public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient, @PathVariable("id")Integer id, Integer drId){

			Patient existingPatient = patientService.getPatientById(id);
			if(existingPatient==null) {
				return ResponseEntity.notFound().build();
			}
			
			// Update only provided fields
			if (patient.getName() != null) {
				existingPatient.setName(patient.getName());
			}
			if (patient.getDoctor() != null) {
				existingPatient.setDoctor(patient.getDoctor());
			}
			if (patient.getDisease() != null) {
				existingPatient.setDisease(patient.getDisease());
			}
			if (patient.getAge()!= null) {
				existingPatient.setAge(patient.getAge());
			}

			Patient updated = patientService.updatePatient(existingPatient);

			return new ResponseEntity<Patient>(updated, HttpStatus.OK);
		}
		
}










