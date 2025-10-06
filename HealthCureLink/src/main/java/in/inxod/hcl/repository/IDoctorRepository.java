package in.inxod.hcl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.inxod.hcl.entity.Doctor;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {

	List<Doctor> findBySpecialization(String specialization);

	List<Doctor> findByExperienceGreaterThan(Integer experience);
	
	
	
}
