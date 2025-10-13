package in.inxod.hcl.service;

import java.time.LocalDate;
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
    public String deleteDoctor(Integer doctorId);  
    // Get Doctor By specialization
    public List<Doctor> getDoctorBySpecialization(String specialization);
    // Get Doctor with experience greater than X year
    public List<Doctor> getDoctorByExperienceGreaterThan(Integer experience);
   

      //======== Patient related ==========
    
    // Add new patient and assign to doctor
    Patient addPatient(Patient patient, Integer doctorId);
    // Update existing patient info
    Patient updatePatient(Patient patient);
    // Delete patient by ID
    String deletePatient(Integer patientId);
    // Get patient by ID
    Patient getPatientById(Integer patientId);
    // Get all patients
    List<Patient> getAllPatients();
    // Get patients by disease
    List<Patient> getPatientsByDisease(String disease);
    // Get patients assigned to a specific doctor
    List<Patient> getPatientsByDoctor(Integer doctorId);
    // Get patients admitted after a certain date
    List<Patient> getPatientsAdmittedAfter(LocalDate date);
    // Get patients admitted between two dates
    List<Patient> getPatientsAdmittedBetween(LocalDate start, LocalDate end);
    
    
}

















