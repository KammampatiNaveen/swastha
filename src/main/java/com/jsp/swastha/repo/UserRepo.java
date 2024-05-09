 package com.jsp.swastha.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.swastha.dto.User;

public interface UserRepo extends JpaRepository<User, String> {
	
	@Query("select a from User a where a.Email=?1")
	User fetchByEmail(String email);
	
	
	@Query("select a from User a where a.bloodGroup=?1 and a.availability='AVAILABLE'")
	List<User> fetchByBlood(String bloodGroup);
	
	@Query("select a from User a where a.id=?1")
	User fetchId(String id);
	
	@Query("select a from User a where a.availability='AVAILABLE'")
	List<User> fetchAllBloodGroup();
}
