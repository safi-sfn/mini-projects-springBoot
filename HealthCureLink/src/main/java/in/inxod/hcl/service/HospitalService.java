package in.inxod.hcl.service;

import java.util.List;

import in.inxod.hcl.entity.Doctor;
import in.inxod.hcl.entity.Patient;

public interface HospitalService {
	
	  // Doctor related
    Doctor addDoctor(Doctor doctor);
    public List<Doctor>getAllDoctor();

    // Patient related
    Patient addPatient(Patient patient);
    public List<Patient>getAllPatient();
}
