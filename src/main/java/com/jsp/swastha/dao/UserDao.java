package com.jsp.swastha.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jsp.swastha.dto.User;
import com.jsp.swastha.exception.DeleteIdNotFound;
import com.jsp.swastha.repo.UserRepo;

@Repository
public class UserDao {
	@Autowired
	private UserRepo userrepo;

	public User saveUser(User user) {
		return userrepo.save(user);
	}

	public User fetchByEmail(String email) {
		User db = userrepo.fetchByEmail(email);
		if (db != null) {
			return db;
		} else {
			return null;
		}
	}
	
//	public String checkAndRegisterEmai(String email) {
//		if(userrepo.existsById(email)) {
//			return "Email already Registered";
//		}else {
//			userrepo.save(new User(email));
//			return "Email registered Successfully";
//		}
//	}

	public User fetchById(String id) {
		Optional<User> db = userrepo.findById(id);
		if (db.isEmpty()) {
			return null;
		} else
			return db.get();
	}

	public List<User> fetchAll() {
		List<User> db = userrepo.findAll();
		if (db.isEmpty())
			return null;
		else
			return db;
	}

	public User delete(String id) {
		Optional<User> db = userrepo.findById(id);
		if (db.isEmpty()){
			throw new DeleteIdNotFound();
		} else {
			User a = userrepo.findById(id).get();
			userrepo.deleteById(id);
		return a;
		}
	}

	public User update(User user) {
		Optional<User> db = userrepo.findById(user.getId());
		if (db.isPresent()) {
			User u = db.get();
			if(user.getFirstName()!=null) {
				u.setFirstName(user.getFirstName());
			}
			if(user.getLastName()!=null) {
				u.setLastName(user.getLastName());
			}
			if(user.getEmail()!=null) {
				u.setEmail(user.getEmail());
			}
			if(user.getAddress()!=null) {
				u.setAddress(user.getAddress());
			}
			if(user.getAvailability()!=null) {
				u.setAvailability(user.getAvailability());
			}
			if(user.getBloodGroup()!=null) {
				u.setBloodGroup(user.getBloodGroup());
			}
			if(user.getGender()!=null) {
				u.setGender(user.getGender());
			}
			if(user.getPassword()!=null) {
				u.setPassword(user.getPassword());
			}
			if(user.getPhone()!=0) {
				u.setPhone(user.getPhone());
			}
			return userrepo.save(u);
		}

		else {
			return null;
		}
	}
	
	public List<User> fetchAllBloodGroup(){
		return userrepo.fetchAllBloodGroup();
		
	}
	
	public List<User> fetchByBlood(String bloodGroup){
		List<User> db = userrepo.fetchByBlood(bloodGroup);
		if(db.isEmpty()) {
			return null;
		}
		else {
			return db;
		}
	}
}
