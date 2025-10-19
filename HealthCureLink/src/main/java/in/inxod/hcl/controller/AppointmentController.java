package in.inxod.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import in.inxod.hcl.service.HospitalServiceImpl;

@RestController
public class AppointmentController {

	@Autowired
	private HospitalServiceImpl appointmtService;
	
	//============APPOINTMENT-RELATED============
}
