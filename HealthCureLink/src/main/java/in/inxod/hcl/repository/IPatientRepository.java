package in.inxod.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.inxod.hcl.entity.Patient;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer>{

}
