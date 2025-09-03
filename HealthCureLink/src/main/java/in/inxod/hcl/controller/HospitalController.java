package in.inxod.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;

import in.inxod.hcl.repository.IAppointmentRepository;
import in.inxod.hcl.repository.IDoctorRepository;
import in.inxod.hcl.repository.IPatientRepository;

public class HospitalController {

	@Autowired
	private IDoctorRepository doctorRepo;
	
	@Autowired
	private IPatientRepository patientRepo;
	
	@Autowired
	private IAppointmentRepository appointmentRepo;
	
	
	//============DOCTOR-RELATED=================
	
	
	
	//============PATIENT-RELATED================
	
	
	
	//============APPOINTMENT-RELATED============
}
