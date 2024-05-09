package com.jsp.swastha.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.swastha.dao.SpecialistDao;
import com.jsp.swastha.dto.Specialist;
import com.jsp.swastha.exception.ExperienceNotFound;
import com.jsp.swastha.exception.SpecialistCityNotFound;
import com.jsp.swastha.exception.SpecialistDeleteIdNotFound;
import com.jsp.swastha.exception.SpecialistEmailWrong;
import com.jsp.swastha.exception.SpecialistFirstNameNotFound;
import com.jsp.swastha.exception.SpecialistIdNotFound;
import com.jsp.swastha.exception.SpecialistLastNameNotFound;
import com.jsp.swastha.exception.SpecialistNotFound;
import com.jsp.swastha.exception.SpecialistPasswordWrong;
import com.jsp.swastha.exception.SpecialistTableEmpty;
import com.jsp.swastha.exception.SpecialistUpdateIdNotFound;
import com.jsp.swastha.util.ResponseStructure;

@Service
public class SpecialistService {

	@Autowired
	private SpecialistDao dao;
	
	@Autowired
	private JavaMailSender emailSender;
	
	ResponseStructure<Specialist> structure=new ResponseStructure<Specialist>();
	
	public ResponseEntity<ResponseStructure<Specialist>> save(Specialist specialist){
		structure.setData(dao.save(specialist));
		structure.setMessage("Specialist Saved Successfully...");
		structure.setStatus(HttpStatus.CREATED.value());
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("venugoud5761@gmail.com");
		message.setTo(specialist.getEmail());
		message.setSubject("mail Registered");
		message.setText("Specialist Mail is Registered Successfully..");
		emailSender.send(message);
		return new ResponseEntity<ResponseStructure<Specialist>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Specialist>> loginSpecialist(Specialist specialist){
		Specialist db = dao.fetchByEmail(specialist.getEmail());
		if(db!=null) {
			if(db.getPassword().equals(specialist.getPassword())) {
				structure.setData(db);
				structure.setMessage("Specialist Login Successfully..");
				structure.setStatus(HttpStatus.FOUND.value());
				return new ResponseEntity<ResponseStructure<Specialist>>(structure, HttpStatus.FOUND);
			}
			throw new SpecialistPasswordWrong();
		}
		throw new SpecialistEmailWrong();
	}
	
	public ResponseEntity<ResponseStructure<Integer>> otpSend(String email){
		Specialist db = dao.fetchByEmail(email);
		if(db!=null) {
			Random random=new Random();
			int value = random.nextInt();
			ResponseStructure<Integer> structure=new ResponseStructure<Integer>();
			structure.setData(value);
			structure.setMessage("OTP Sent Successfully..");
			structure.setStatus(HttpStatus.FOUND.value());
			SimpleMailMessage message=new SimpleMailMessage();
			message.setFrom("venugoud5761@gmail.com");
			message.setTo(email);
			message.setSubject("OTP Verification");
			message.setText("Please Enter OTP: "+value);
			emailSender.send(message);
			return new ResponseEntity<ResponseStructure<Integer>>(structure, HttpStatus.FOUND);
		}
		throw new SpecialistEmailWrong();
	}
	
	public ResponseEntity<ResponseStructure<Specialist>> fetchById(String id){
		Specialist db = dao.fetchById(id);
		if(db!=null) {
			ResponseStructure<Specialist> structure=new ResponseStructure<Specialist>();
			structure.setData(dao.fetchById(id));
			structure.setMessage("Specialist Id Fetch Successfully...");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Specialist>>(structure, HttpStatus.FOUND);
		}
		throw new SpecialistIdNotFound();
	}
	
	public ResponseEntity<ResponseStructure<Specialist>> deleteById(String id){
		Specialist db = dao.fetchById(id);
		if(db!=null) {
			ResponseStructure<Specialist> structure=new ResponseStructure<Specialist>();
			structure.setData(dao.deleteById(id));
			structure.setMessage("Specialist Id Deleted Successfully...");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Specialist>>(structure, HttpStatus.OK);
		}
		throw new SpecialistDeleteIdNotFound();
	}
	
	public ResponseEntity<ResponseStructure<Specialist>> update(Specialist specialist){
		Specialist db = dao.fetchById(specialist.getSpe_id());
		if(db!=null) {
			ResponseStructure<Specialist> structure=new ResponseStructure<Specialist>();
			structure.setData(dao.update(specialist));
			structure.setMessage("Specialist Details Updated Successfully...");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Specialist>>(structure, HttpStatus.OK);	
		}
		throw new SpecialistUpdateIdNotFound();
	}
	
	public ResponseEntity<ResponseStructure<List<Specialist>>> fetchByFirstName(String firstname){
		List<Specialist> db = dao.fetchByFirstName(firstname);
		if(db!=null) {
			ResponseStructure<List<Specialist>> structure=new ResponseStructure<List<Specialist>>();
			structure.setData(db);
			structure.setMessage("Specialist First Name Found Successfully...");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Specialist>>>(structure, HttpStatus.FOUND);
		}
		throw new SpecialistFirstNameNotFound();
	}
	
	public ResponseEntity<ResponseStructure<List<Specialist>>> fetchByLastName(String lastName){
		List<Specialist> db = dao.fetchByLastName(lastName);
		if(db!=null) {
			ResponseStructure<List<Specialist>> structure=new ResponseStructure<List<Specialist>>();
			structure.setData(db);
			structure.setMessage("Specialist Last Name Found Successfully...");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Specialist>>>(structure, HttpStatus.FOUND);
		}
		throw new SpecialistLastNameNotFound();
	}
	
	public ResponseEntity<ResponseStructure<List<Specialist>>> fetchByExperience(String experience){
		List<Specialist> db = dao.fetchByExperience(experience);
		if(db!=null) {
			ResponseStructure<List<Specialist>> structure=new ResponseStructure<List<Specialist>>();
			structure.setData(db);
			structure.setMessage("Specialist Experience Found Successfully..");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Specialist>>>(structure, HttpStatus.FOUND);
		}
		throw new ExperienceNotFound();
	}
	
	public ResponseEntity<ResponseStructure<List<Specialist>>> fetchBySpecialist(String specialist){
		List<Specialist> db = dao.fetchBySpecialist(specialist);
		if(db!=null) {
			ResponseStructure<List<Specialist>> structure=new ResponseStructure<List<Specialist>>();
			structure.setData(db);
			structure.setMessage("Specialist Found Successfully...");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Specialist>>>(structure, HttpStatus.FOUND);
		}
		throw new SpecialistNotFound();
	}
	
	public ResponseEntity<ResponseStructure<List<Specialist>>> fetchAll(){
		List<Specialist> db = dao.fetchAll();
		if(db!=null) {
			ResponseStructure<List<Specialist>> structure=new ResponseStructure<List<Specialist>>();
			structure.setData(db);
			structure.setMessage("All Specialist are Fetched Successfully...");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Specialist>>>(structure, HttpStatus.FOUND);
		}
		throw new SpecialistTableEmpty();
	}
	
	public ResponseEntity<ResponseStructure<List<Specialist>>> fetchCity(String city){
		List<Specialist> db = dao.fetchByCity(city);
		if(db!=null) {
			ResponseStructure<List<Specialist>> structure=new ResponseStructure<List<Specialist>>();
			structure.setData(db);
			structure.setMessage("Fetching City Successfully...");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Specialist>>>(structure, HttpStatus.FOUND);
		}
		throw new SpecialistCityNotFound();
	}
	
	public ResponseEntity<ResponseStructure<Specialist>> fetchByEmail(String email){
		Specialist db = dao.fetchByEmail(email);
		if(db!=null) {
			ResponseStructure<Specialist> structure=new ResponseStructure<Specialist>();
			structure.setData(db);
			structure.setMessage("Fetching Email Successfully...");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Specialist>>(structure, HttpStatus.FOUND);
		}
		throw new SpecialistEmailWrong();
	}

}
