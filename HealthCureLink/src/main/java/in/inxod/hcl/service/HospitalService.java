package in.inxod.hcl.service;

import java.util.List;

import in.inxod.hcl.entity.Doctor;
import in.inxod.hcl.entity.Patient;

public interface HospitalService {
	
	  //======== Doctor related ==========
	
	//  Add a new doctor
    public Doctor addDoctor(Doctor doctor);
    //  Get all doctors
    public List<Doctor>getAllDoctor();
    // Get Doctor By Id
    public Doctor getDoctorById(Integer doctorId);
    //  Update Doctor Details
    public Doctor updateDoctor(Doctor doctor);
    //  Delete Doctor
    void deleteDoctor(Integer doctorId);  
    // Get Doctor By specialization
    public List<Doctor> getDoctorBySpecialization(String specialization);
    // Get Doctor with experience greater than X year
    public List<Doctor> getDoctorByExperienceGreaterThan(Integer experience);
   

    // Patient related
    public Patient addPatient(Patient patient);
    public List<Patient>getAllPatient();
}
