package in.inxod.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.inxod.hcl.entity.Doctor;
import in.inxod.hcl.entity.Patient;
import in.inxod.hcl.repository.IDoctorRepository;
import in.inxod.hcl.repository.IPatientRepository;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	IPatientRepository patientRepo;
	
	@Autowired
	IDoctorRepository doctorRepo;

	
	
	//============== Doctor related =============
	
	@Override
	public Doctor addDoctor(Doctor doctor) {
		
		return doctorRepo.save(doctor);
	}
	
	@Override
	public List<Doctor> getAllDoctor() {
		
		return doctorRepo.findAll();
	}
	
	
	
	
	//============== Patient related =============
	

	@Override
	public Patient addPatient(Patient patient) {
		
		return patientRepo.save(patient);
	}

	@Override
	public List<Patient> getAllPatient() {
		
		return patientRepo.findAll();
	}

}
