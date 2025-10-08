package in.inxod.hcl.service;

import java.util.List;
import java.util.Optional;

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
	
	public Doctor getDoctorById(Integer doctorId) {
		Optional<Doctor> optional =  doctorRepo.findById(doctorId);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	@Override
	public Doctor updateDoctor(Doctor doctor) {
		
		return doctorRepo.save(doctor);
	}

	@Override
	public String deleteDoctor(Integer doctorId) {
		Optional<Doctor> optional = doctorRepo.findById(doctorId);
		if(optional.isPresent()) {
			doctorRepo.deleteById(doctorId);
			return "Deleted";
		}
		return "Doctor Not Found with give Id";
	}

	@Override
	public List<Doctor> getDoctorBySpecialization(String specialization) {
		
		return doctorRepo.findBySpecialization(specialization);
	}

	@Override
	public List<Doctor> getDoctorByExperienceGreaterThan(Integer experience) {
		return doctorRepo.findByExperienceGreaterThanEqual(experience);
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
