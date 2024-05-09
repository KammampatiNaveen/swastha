package com.jsp.swastha.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.swastha.dto.AppointmentDate;
import com.jsp.swastha.dto.Specialist;
import com.jsp.swastha.dto.User;

public interface AppoinmentDateRepo extends JpaRepository<AppointmentDate, String> {

	@Query("select a from User a where a.id=?1")
	User findUserId(String id);
	
	@Query("select a from Specialist a where a.spe_id=?1")
	Specialist findSpecialistId(String id);
	
}
