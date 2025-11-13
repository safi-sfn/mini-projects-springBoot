package in.inxod.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.inxod.hcl.entity.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer>{

	// Book New Appointment
	public Appointment bookAppointment(Appointment appointment, Integer patientId, Integer doctorId);
	
}
