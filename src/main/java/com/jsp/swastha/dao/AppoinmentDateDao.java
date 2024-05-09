package com.jsp.swastha.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.swastha.dto.AppointmentDate;
import com.jsp.swastha.dto.Specialist;
import com.jsp.swastha.dto.User;
import com.jsp.swastha.repo.AppoinmentDateRepo;
import com.jsp.swastha.repo.SpecialistRepo;
import com.jsp.swastha.repo.UserRepo;

@Repository
public class AppoinmentDateDao {

	@Autowired
	private AppoinmentDateRepo repo;
	
	public User findUserId(String userId) {
		return repo.findUserId(userId);
	}
	
	public Specialist findSpecialistId(String spe_id) {
		return repo.findSpecialistId(spe_id);
	}
	
	public AppointmentDate save(AppointmentDate appointmentDate) {
		return repo.save(appointmentDate);
	}
	
}
