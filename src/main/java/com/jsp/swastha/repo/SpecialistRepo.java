package com.jsp.swastha.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.swastha.dto.Specialist;

public interface SpecialistRepo extends JpaRepository<Specialist, String> {

	@Query("select a from Specialist a where a.email=?1")
	Specialist fetchByEmail(String email);
	
	@Query("select a from Specialist a where a.firstname=?1")
	List<Specialist> fetchByFirstName(String firstname);
	
	@Query("select a from Specialist a where a.lastName=?1")
	List<Specialist> fetchByLastName(String lastName);
	
	@Query("select a from Specialist a where a.specialization=?1")
	List<Specialist> fetchSpecialist(String specialist);
	
	@Query("select a from Specialist a where a.experience=?1")
	List<Specialist> fetchExperience(String experience);
	
	@Query("select a from Specialist a where a.id=?1")
	Specialist fetchId(String id);
	
	@Query("select a from Specialist a join a.address b where b.city=?1")
	List<Specialist> fetchByCity(String city);
	
	
}
