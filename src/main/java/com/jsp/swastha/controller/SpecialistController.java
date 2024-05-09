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

import com.jsp.swastha.dto.Specialist;
import com.jsp.swastha.service.SpecialistService;
import com.jsp.swastha.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST,RequestMethod.PUT,RequestMethod.GET,RequestMethod.DELETE})
public class SpecialistController {

	@Autowired
	private SpecialistService service;
	
	@PostMapping("/specialistSave")
	public ResponseEntity<ResponseStructure<Specialist>> save(@RequestBody Specialist specialist){
		return service.save(specialist);
	}
	
	@PostMapping("/specialistLogin")
	public ResponseEntity<ResponseStructure<Specialist>> login(@RequestBody Specialist specialist){
		return service.loginSpecialist(specialist);
	}
	
	@PostMapping("/otpSend")
	public ResponseEntity<ResponseStructure<Integer>> otpSend(@RequestParam String email){
		return service.otpSend(email);
	}
	
	@PutMapping("/updateSpecialist")
	public ResponseEntity<ResponseStructure<Specialist>> update(@RequestBody Specialist specialist){
		return service.update(specialist);
	}
	
	@GetMapping("/fetchId")
	public ResponseEntity<ResponseStructure<Specialist>> fetchById(@RequestParam String id){
		return service.fetchById(id);
	}
	
	@DeleteMapping("/deleteSpecialistById")
	public ResponseEntity<ResponseStructure<Specialist>> deleteById(@RequestParam String id){
		return service.deleteById(id);
	}
	
	@GetMapping("/firstName")
	public ResponseEntity<ResponseStructure<List<Specialist>>> fetchByFirstName(@RequestParam String firstname){
		return service.fetchByFirstName(firstname);
	}
	
	@GetMapping("/lastName")
	public ResponseEntity<ResponseStructure<List<Specialist>>> fetchByLastName(@RequestParam String lastName){
		return service.fetchByLastName(lastName);
	}
	
	@GetMapping("/experience")
	public ResponseEntity<ResponseStructure<List<Specialist>>> fetchByExperience(@RequestParam String experience){
		return service.fetchByExperience(experience);
	}
	
	@GetMapping("/specialist")
	public ResponseEntity<ResponseStructure<List<Specialist>>> fetchBySpecialist(@RequestParam String specialist){
		return service.fetchBySpecialist(specialist);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<ResponseStructure<List<Specialist>>> fetchAll(){
		return service.fetchAll();
	}
	
	@GetMapping("/fetchCity")
	public ResponseEntity<ResponseStructure<List<Specialist>>> fetchByCity(@RequestParam String city){
		return service.fetchCity(city);
	}
	
	@GetMapping("/fetchBySpecialistEmail")
	public ResponseEntity<ResponseStructure<Specialist>> fetchByEmail(@RequestParam String email){
		return service.fetchByEmail(email);
	}
}
