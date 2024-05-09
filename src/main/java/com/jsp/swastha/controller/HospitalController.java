package com.jsp.swastha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.swastha.dto.Hospital;
import com.jsp.swastha.service.HospitalService;
import com.jsp.swastha.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class HospitalController {

	@Autowired
	private HospitalService service;
	
	@PostMapping("/hospitalSave")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestParam String spe_id,@RequestBody Hospital hospital){
		return service.saveHospital(spe_id, hospital);
	}
	
	@PutMapping("/updateHospital")
	public ResponseEntity<ResponseStructure<Hospital>> update(@RequestParam String spe_id,@RequestBody Hospital hospital){
		return service.saveHospital(spe_id, hospital);
	}
	
	@DeleteMapping("/deleteByIdHospital")
	public ResponseEntity<ResponseStructure<Hospital>> deleteById(@RequestParam String spe_id,@RequestParam String id){
		return service.deleteById(spe_id, id);
	}
}
