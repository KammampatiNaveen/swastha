package com.jsp.swastha.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.swastha.dto.Specialist;
import com.jsp.swastha.exception.SpecialistDeleteIdNotFound;
import com.jsp.swastha.repo.SpecialistRepo;

@Repository
public class SpecialistDao {

	@Autowired
	private SpecialistRepo repo;
	
	public Specialist save(Specialist specialist) {
		return repo.save(specialist);
	}
	
	
	public Specialist fetchById(String id) {
		Optional<Specialist> db = repo.findById(id);
		if(db.isEmpty()) {
			return null;
		}
		else
			return db.get();
	}
	
	public Specialist deleteById(String id) {
		Optional<Specialist> db = repo.findById(id);
		if(db.isEmpty()) {
			throw new SpecialistDeleteIdNotFound();
		}
		else {
			repo.deleteById(id);
		return db.get();
		}
	}
	
	public Specialist update(Specialist specialist) {
		Optional<Specialist> db = repo.findById(specialist.getSpe_id());
		if(db.isPresent()) {
			Specialist s=db.get();
			if(specialist.getFirstname()!=null) {
				s.setFirstname(specialist.getFirstname());
			}
			if(specialist.getLastName()!=null) {
				s.setLastName(specialist.getLastName());
			}
			if(specialist.getPhone()!=0) {
				s.setPhone(specialist.getPhone());
			}
			if(specialist.getAddress()!=null) {
				s.setAddress(specialist.getAddress());
			}
			if(specialist.getAge()!=0) {
				s.setAge(specialist.getAge());
			}
			if(specialist.getEmail()!=null) {
				s.setEmail(specialist.getEmail());
			}
			if(specialist.getExperience()!=null) {
				s.setExperience(specialist.getExperience());
			}
			if(specialist.getFees()!=0.0) {
				s.setFees(specialist.getFees());
			}
			if(specialist.getGender()!=null) {
				s.setGender(specialist.getGender());
			}
			if(specialist.getPassword()!=null) {
				s.setPassword(specialist.getPassword());
			}
			if(specialist.getSpecialization()!=null) {
				s.setSpecialization(specialist.getSpecialization());
			}
			return repo.save(s);
		}
		else {
			return null;
		}
	}
	
	public List<Specialist> fetchAll(){
		List<Specialist> db = repo.findAll();
		if(db.isEmpty()) {
			return null;
		}
		else
			return db;
	}
	
	public Specialist fetchByEmail(String email) {
		Specialist db = repo.fetchByEmail(email);
		if(db!=null) {
			return db;
		}
		else {
			return null;
		}
	}
	public List<Specialist> fetchByFirstName(String firstname) {
		List<Specialist> db = repo.fetchByFirstName(firstname);
		if(db.isEmpty()) {
			return null;
		}
		else
			return db;
	}
	
	public List<Specialist> fetchByLastName(String lastName) {
		 List<Specialist> db = repo.fetchByLastName(lastName);
		if(db.isEmpty()) {
			return null;
		}
		else
			return db;
	}
	public List<Specialist> fetchBySpecialist(String specialist){
		List<Specialist> db = repo.fetchSpecialist(specialist);
		if(db.isEmpty()) {
			return null;
		}
		else
			return db;
	}
	
	public List<Specialist> fetchByExperience(String experience){
		List<Specialist> db = repo.fetchExperience(experience);
		if(db.isEmpty()) {
			return null;
		}
		else
			return db;
	}
	
	public List<Specialist> fetchByCity(String city) {
		List<Specialist> db = repo.fetchByCity(city);
		if(db.isEmpty()) {
			return null;
		}
		else
			return db;
	}
	
}
