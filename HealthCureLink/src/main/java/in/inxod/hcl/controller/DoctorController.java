package in.inxod.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.inxod.hcl.entity.Doctor;
import in.inxod.hcl.entity.Patient;
import in.inxod.hcl.service.HospitalServiceImpl;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private HospitalServiceImpl doctorService;
	
	
	//============DOCTOR-RELATED=================
	
	@PostMapping("/add")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
		Doctor newDoctor =  doctorService.addDoctor(doctor);
		return new ResponseEntity<Doctor>(newDoctor, HttpStatus.CREATED);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Doctor>> getAllDoctor(){
		List<Doctor> allDoctors = doctorService.getAllDoctor();
		return new ResponseEntity<List<Doctor>>(allDoctors, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor){
		Doctor existingDoctor = doctorService.getDoctorById(doctor.getDoctorId());
		if(existingDoctor == null) {
			return ResponseEntity.notFound().build();
		}
		
		existingDoctor.setName(doctor.getName());
		existingDoctor.setExperience(doctor.getExperience());
		existingDoctor.setSalary(doctor.getSalary());
		existingDoctor.setSpecialization(doctor.getSpecialization());
		
		Doctor updateDoctor= doctorService.addDoctor(existingDoctor);
		return new ResponseEntity<Doctor>(updateDoctor,HttpStatus.OK);
		
	}
	
	
	

}
