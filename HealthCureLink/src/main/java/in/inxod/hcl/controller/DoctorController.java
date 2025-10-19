package in.inxod.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.inxod.hcl.entity.Doctor;
import in.inxod.hcl.service.HospitalServiceImpl;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private HospitalServiceImpl doctorService;

	// ============DOCTOR-RELATED=================

	@PostMapping("/add")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
		Doctor newDoctor = doctorService.addDoctor(doctor);
		return new ResponseEntity<Doctor>(newDoctor, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Doctor>> getAllDoctor() {
		List<Doctor> allDoctors = doctorService.getAllDoctor();
		return new ResponseEntity<List<Doctor>>(allDoctors, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable Integer id, @RequestBody Doctor doctor) {
		Doctor existingDoctor = doctorService.getDoctorById(id);
		if (existingDoctor == null) {
			return ResponseEntity.notFound().build();
		}

		existingDoctor.setName(doctor.getName());
		existingDoctor.setExperience(doctor.getExperience());
		existingDoctor.setSalary(doctor.getSalary());
		existingDoctor.setSpecialization(doctor.getSpecialization());

		Doctor updateDoctor = doctorService.addDoctor(existingDoctor);
		return new ResponseEntity<Doctor>(updateDoctor, HttpStatus.OK);

	}

	@PatchMapping("update-field/{id}")
	public ResponseEntity<Doctor> updateDoctorFields(@PathVariable Integer id, @RequestBody Doctor doctor) {
		Doctor existing = doctorService.getDoctorById(id);
		if (existing == null) {
			return ResponseEntity.notFound().build();
		}

		// Update only provided fields
		if (doctor.getName() != null) {
			existing.setName(doctor.getName());
		}
		if (doctor.getSpecialization() != null) {
			existing.setSpecialization(doctor.getSpecialization());
		}
		if (doctor.getExperience() != null) {
			existing.setExperience(doctor.getExperience());
		}
		if (doctor.getSalary() != null) {
			existing.setSalary(doctor.getSalary());
		}

		Doctor updated = doctorService.addDoctor(existing);

		return new ResponseEntity<Doctor>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("id") Integer id) {
		String status = doctorService.deleteDoctor(id);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	@GetMapping("/specialization/{drSpslize}")
	public ResponseEntity<?> getDoctorBySpecialization(@PathVariable("drSpslize") String drSpslize) {
		List<Doctor> drList = doctorService.getDoctorBySpecialization(drSpslize);
		if (drList.isEmpty()) {
			String msg = "No doctors found with specialization: " + drSpslize;
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
		}
		return new ResponseEntity<List<Doctor>>(drList, HttpStatus.OK);
	}

	@GetMapping("/experience/{exp}")
	public ResponseEntity<?> getDoctorByExperienceGreaterThan(@PathVariable("exp") Integer experience) {
		List<Doctor> drList = doctorService.getDoctorByExperienceGreaterThan(experience);
		if (drList.isEmpty()) {
			String msg = "No doctor with given Experience " + experience;
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
		}
		return new ResponseEntity<>(drList, HttpStatus.OK);

	}

}
