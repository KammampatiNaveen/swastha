package com.jsp.swastha.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.swastha.dto.Hospital;
import com.jsp.swastha.dto.Specialist;
import com.jsp.swastha.exception.HospitalDeleteIdNotFound;
import com.jsp.swastha.exception.HospitalUpdateIdNotFound;
import com.jsp.swastha.repo.HospitalRepo;

@Repository
public class HospitalDao {

	@Autowired
	private HospitalRepo repo;
	
	public Hospital saveHospital(Hospital hospital) {
		return repo.save(hospital);
	}
	
	public Hospital update(Hospital hospital) {
		Optional<Hospital> db = repo.findById(hospital.getId());
		if(db!=null) {
			Hospital h = db.get();
			if(hospital.getEmail()!=null) {
				h.setEmail(hospital.getEmail());
			}
			if(hospital.getHospitalName()!=null) {
				h.setHospitalName(hospital.getHospitalName());
			}
			if(hospital.getPhone()!=0) {
				h.setPhone(hospital.getPhone());
			}
			if(hospital.getPincode()!=0) {
				h.setPincode(hospital.getPincode());
			}
			if(hospital.getAddress()!=null) {
				h.setAddress(hospital.getAddress());
			}
			if(hospital.getWebsite()!=null) {
				h.setWebsite(hospital.getWebsite());
			}
			if(hospital.getSpecialist()!=null) {
				h.setSpecialist(hospital.getSpecialist());
			}
			return repo.save(h);
		}
		throw new HospitalUpdateIdNotFound();
	}
	
	public Hospital deleteById(String id) {
		Optional<Hospital> db = repo.findById(id);
		if(db.isEmpty()) {
			throw new HospitalDeleteIdNotFound();
		}
		else {
			repo.deleteById(id);
			return db.get();
		}
	}
	public Hospital fetchById(String id) {
		Optional<Hospital> db = repo.findById(id);
		if(db.isEmpty()) {
			return null;
		}else {
			return db.get();
		}
	}
	
	public Specialist fetchSpecialistId(String spe_id) {
		return repo.fetchId(spe_id);
	}
	
}
