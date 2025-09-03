package in.inxod.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.inxod.hcl.entity.Doctor;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {

}
