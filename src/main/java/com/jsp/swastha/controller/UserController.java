package com.jsp.swastha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.swastha.dao.UserDao;
import com.jsp.swastha.dto.User;
import com.jsp.swastha.service.UserService;
import com.jsp.swastha.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {
	@Autowired
	private UserService userservice;
	
	@PostMapping("/user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		System.out.println(user);
		return userservice.saveUser(user);
	}

	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<User>> loginUser(@RequestParam String email, @RequestParam String password) {
		return userservice.loginUser(email, password);
	}
	
//	@GetMapping("/fetchByEmail")
//	public ResponseEntity<ResponseStructure<User>> fetchByEmail(@RequestParam String email){
//		return userservice.fetchByEmail(email);
//	}
	
	@PostMapping("/otpsend")
	public ResponseEntity<ResponseStructure<Integer>> otpsend(@RequestParam String email) {
		return userservice.otpsend(email);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<User>> update(@RequestBody User user){
		return userservice.update(user);
	}
	
	@GetMapping("/fetchById")
	public ResponseEntity<ResponseStructure<User>> fetchById(@RequestParam String id){
		return userservice.fetchById(id);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<User>> deleteById(@RequestParam String id){
		return userservice.deleteById(id);
	}

	@GetMapping("/fetchAllBloodGroup")
	public ResponseEntity<ResponseStructure<List<User>>> fetchAllBloodGroup(){
		return userservice.fetchAllBloodGroup();
	}
	
	@GetMapping("/fetchByEmail")
	public ResponseEntity<ResponseStructure<User>> fetchByEmail(@RequestParam String email){
		return userservice.fetchByEmail(email);
	}
	
	@GetMapping("/fetchByBloodGroup")
	public ResponseEntity<ResponseStructure<List<User>>> fetchByBloodGroup(@RequestParam String bloodGroup){
		return userservice.fetchByBloodGroup(bloodGroup);
	}
}
