package in.inxod.hcl.service;

import java.time.LocalDate;
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

	// ============== Doctor related =============

	@Override
	public Doctor addDoctor(Doctor doctor) {

		return doctorRepo.save(doctor);
	}

	@Override
	public List<Doctor> getAllDoctor() {

		return doctorRepo.findAll();
	}

	public Doctor getDoctorById(Integer doctorId) {
		Optional<Doctor> optional = doctorRepo.findById(doctorId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
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
		if (optional.isPresent()) {
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

	// ============== Patient related =============

	@Override
	public Patient addPatient(Patient patient, Integer doctorId) {
		Doctor doctor = doctorRepo.findById(doctorId)
				.orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doctorId));
		patient.setDoctor(doctor);
		return patientRepo.save(patient);
	}

	@Override
	public List<Patient> getAllPatients() {

		return patientRepo.findAll();
	}

	@Override
	public Patient updatePatient(Patient patient) {

		return patientRepo.save(patient);
	}

	@Override
	public String deletePatient(Integer patientId) {
		Optional<Patient> optional = patientRepo.findById(patientId);
		if(optional.isPresent()) {
			patientRepo.deleteById(patientId);
			return "Patient Delete";
		}
		else {
			return "Patient Not Found with this Id : "+patientId;
		}
		
	}

	@Override
	public Patient getPatientById(Integer patientId) {
		Optional<Patient> optional = patientRepo.findById(patientId);
		if (optional.isPresent()) {
			return optional.get();
		} else {

			return null;
		}
	}

	@Override
	public List<Patient> getPatientsByDisease(String disease) {

	List<Patient> patientList = patientRepo.findByDisease(disease);
		return patientList;
	}

	@Override
	public List<Patient> getPatientsByDoctor(String doctorName) {

		List<Patient> patientList = patientRepo.findByDoctorName(doctorName);
		
		return patientList;
	}

	@Override
	public List<Patient> getPatientsAdmittedAfter(LocalDate date) {

		return null;
	}

	@Override
	public List<Patient> getPatientsAdmittedBetween(LocalDate start, LocalDate end) {

		return null;
	}

}
