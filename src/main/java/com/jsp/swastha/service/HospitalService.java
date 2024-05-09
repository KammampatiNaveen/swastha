package com.jsp.swastha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.swastha.dao.HospitalDao;
import com.jsp.swastha.dto.Hospital;
import com.jsp.swastha.dto.Specialist;
import com.jsp.swastha.exception.HospitalDeleteIdNotFound;
import com.jsp.swastha.exception.HospitalIsNotPresent;
import com.jsp.swastha.exception.HospitalUpdateIdNotFound;
import com.jsp.swastha.exception.SpecialistAdminNotFound;
import com.jsp.swastha.exception.SpecialistIdNotFound;
import com.jsp.swastha.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao dao;
	
	ResponseStructure<Hospital> structure=new ResponseStructure<Hospital>();
	
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(String spe_id,Hospital hospital){ 
		Specialist db = dao.fetchSpecialistId(spe_id);
		if(db!=null) {
			if(db.getSpecialization()!=null && db.getSpecialization().equalsIgnoreCase("admin")) {
				Hospital hos = dao.saveHospital(hospital);
				structure.setData(hos);
				structure.setMessage("Hospital Saved Successfully..");
				structure.setStatus(HttpStatus.CREATED.value());
				return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.CREATED);
			}
			throw new SpecialistAdminNotFound();
		}
		throw new SpecialistIdNotFound();
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(String spe_id,Hospital hospital){
		Specialist db = dao.fetchSpecialistId(spe_id);
		if(db!=null) {
			if(db.getSpecialization()!=null && db.getSpecialization().equalsIgnoreCase("admin")) {
				Hospital hos = dao.update(hospital);
				if(hos!=null) {
					ResponseStructure<Hospital> structure=new ResponseStructure<Hospital>();
					structure.setData(dao.update(hospital));
					structure.setMessage("Hospital Details Updated Successfully...");
					structure.setStatus(HttpStatus.OK.value());
					return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
				}
				throw new HospitalIsNotPresent();
			}
			throw new HospitalUpdateIdNotFound();
		}
			throw new SpecialistIdNotFound("Specialist Id"+spe_id+" Not Found");
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> deleteById(String spe_id,String id){
		Specialist db = dao.fetchSpecialistId(spe_id);
		if(db!=null) {
			if(db.getSpecialization()!=null && db.getSpecialization().equalsIgnoreCase("admin")) {
				Hospital hos = dao.deleteById(id);
				if(hos!=null) {
					ResponseStructure<Hospital> structure=new ResponseStructure<Hospital>();
					structure.setData(hos);
					structure.setMessage("Hospital Id Deleted Successfully...");
					structure.setStatus(HttpStatus.OK.value());
					return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
				}
			}
			throw new SpecialistAdminNotFound();
		}
		throw new HospitalDeleteIdNotFound("Hospital Delete id "+id+" Not Found");
	}
	
	
	
}
