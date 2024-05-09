package com.jsp.swastha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.swastha.dto.AppointmentDate;
import com.jsp.swastha.service.AppoinmentDateService;
import com.jsp.swastha.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST})
public class AppoinmentDateController {

	@Autowired
	private AppoinmentDateService service;
	
	@PostMapping("/slot")
	public ResponseEntity<ResponseStructure<AppointmentDate>> save(@RequestParam String userId,@RequestParam String spe_id,@RequestBody AppointmentDate appointmentDate){
		return service.bookingSlot(userId, spe_id, appointmentDate);
	}
}
