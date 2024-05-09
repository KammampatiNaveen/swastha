package com.jsp.swastha.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jsp.swastha.dao.UserDao;
import com.jsp.swastha.dto.User;
import com.jsp.swastha.exception.DeleteIdNotFound;
import com.jsp.swastha.exception.EmailWrongException;
import com.jsp.swastha.exception.FetchingBloodGroupNotFound;
import com.jsp.swastha.exception.PasswordWrongException;
import com.jsp.swastha.exception.UserIdNotFound;
import com.jsp.swastha.exception.UserUpdateIdNotFound;
import com.jsp.swastha.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	@Autowired
	private JavaMailSender emailSender;

	ResponseStructure<User> structure = new ResponseStructure<User>();

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		structure.setData(dao.saveUser(user));
		structure.setMessage("user saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("venugoud5761@gmail.com");
		message.setTo(user.getEmail());
		message.setSubject("mail registration");
		message.setText("your mail is registered successffuly");
		emailSender.send(message);
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<User>> loginUser(String email , String password) {
		User db = dao.fetchByEmail(email);
		if (db != null) {
			if (db.getPassword().equals(password)) {
				structure.setData(db);
				structure.setMessage("user login successfully");
				structure.setStatus(HttpStatus.FOUND.value());
				return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
			}
			throw new PasswordWrongException();
		}
		throw new EmailWrongException();

	}

	public ResponseEntity<ResponseStructure<Integer>> otpsend(String email) {
		User db = dao.fetchByEmail(email);
		if (db != null) {
			Random random = new Random();
			int value = random.nextInt();
			ResponseStructure<Integer> structure1 = new ResponseStructure<Integer>();
			structure1.setData(value);
			structure1.setMessage("otp sent successfully");
			structure1.setStatus(HttpStatus.FOUND.value());
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("venugoud5761@gmail.com");
			message.setTo(email);
			message.setSubject("otp verification");
			message.setText("please enter otp: "+value);
			emailSender.send(message);
			return new ResponseEntity<ResponseStructure<Integer>>(structure1, HttpStatus.FOUND);
		}
		throw new EmailWrongException();
	}

	
	public ResponseEntity<ResponseStructure<User>> update(User user){
		User db = dao.fetchById(user.getId());
		if(db!=null) {
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setData(dao.update(user));
			structure.setMessage("Usre Details Update Successfully...");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		else 
			throw new UserUpdateIdNotFound();
	}
	
	public ResponseEntity<ResponseStructure<User>> fetchById(String id){
		User db = dao.fetchById(id);
		if(db!=null) {
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setData(db);
			structure.setMessage("User Id Find Successfully....");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
		}
		else 
			throw new UserIdNotFound("User Id "+id+" is not Found");
	}
	
	public ResponseEntity<ResponseStructure<User>> fetchByEmail(String email){
		User db = dao.fetchByEmail(email);
		if(db!=null) {
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setData(db);
			structure.setMessage("Fetch Email Successfully...");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
		}else {
			throw new EmailWrongException("User email "+email+" is not Found");
		}
	}
	
	public ResponseEntity<ResponseStructure<User>> deleteById(String id){
		User db = dao.fetchById(id);
		if(db!=null) {
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setData(dao.delete(id));
			structure.setMessage("User Id Deleted Successfully...");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		else
			throw new DeleteIdNotFound();
	}
		
	public ResponseEntity<ResponseStructure<List<User>>> fetchAllBloodGroup(){
		List<User> db = dao.fetchAllBloodGroup();
		if(db!=null) {
			ResponseStructure<List<User>> structure=new ResponseStructure<List<User>>();
			structure.setData(db);
			structure.setMessage("Fetching All Blood Group Successfully..");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.FOUND);
		}
		else
			throw new FetchingBloodGroupNotFound();	
	}
	
	public ResponseEntity<ResponseStructure<List<User>>> fetchByBloodGroup(String bloodGroup){
		List<User> db = dao.fetchByBlood(bloodGroup);
		if(db!=null) {
			ResponseStructure<List<User>> structure=new ResponseStructure<List<User>>();
			structure.setData(db);
			structure.setMessage("Fetch Blood Group Successfully...");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.FOUND);
		}
		else {
			throw new FetchingBloodGroupNotFound();
		}
	}

}
