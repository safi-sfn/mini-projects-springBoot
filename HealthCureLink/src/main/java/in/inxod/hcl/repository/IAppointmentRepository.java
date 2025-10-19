package in.inxod.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.inxod.hcl.entity.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer>{

}
