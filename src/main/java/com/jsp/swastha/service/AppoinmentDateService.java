package com.jsp.swastha.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jsp.swastha.dao.AppoinmentDateDao;
import com.jsp.swastha.dao.PaymentDao;
import com.jsp.swastha.dto.AppointmentDate;
import com.jsp.swastha.dto.Payment;
import com.jsp.swastha.dto.Slot;
import com.jsp.swastha.dto.Specialist;
import com.jsp.swastha.dto.User;
import com.jsp.swastha.exception.SpecialistIdNotFound;
import com.jsp.swastha.exception.UserIdNotFound;
import com.jsp.swastha.util.ResponseStructure;

@Service
public class AppoinmentDateService {

	@Autowired
	private AppoinmentDateDao dao;
	
	@Autowired
	private PaymentDao paymentDao;
	
	@Autowired
	private JavaMailSender emailSender;
	
	ResponseStructure<AppointmentDate> structure=new ResponseStructure<AppointmentDate>();
	
	
	public ResponseEntity<ResponseStructure<AppointmentDate>> bookingSlot(String userId,String spe_id,AppointmentDate appointmentDate){
		User db = dao.findUserId(userId);
		if(db!=null) {
			Specialist sp = dao.findSpecialistId(spe_id);
			if(sp!=null) {
//				Date date = Date.valueOf(appointmentDate.getDate().toString());
//				appointmentDate.setDate(date);
//				dao.save(appointmentDate);
				AppointmentDate slot = dao.save(appointmentDate);
				structure.setData(slot);
				structure.setMessage("Your Slot is Successfully Booked");
				structure.setStatus(HttpStatus.CREATED.value());
				
				if(slot!=null) {
					List<Slot> list = slot.getSlots();
					for (Slot appSlot : list) {
						if(appSlot!=null) {
							paymentDao.saveSlot(appSlot.getPayment());
							SimpleMailMessage message=new SimpleMailMessage();
//							message.setFrom("venugoud5761@gmail.com");
							message.setTo(db.getEmail());
							message.setSubject("Your Slot is Successfully Booked");
							message.setText("SlotDate :"+slot.getDate().toString()+"\n"+"Slot Time : "+appSlot.getTime()+"\n"+"Specialist Name : "+sp.getFirstname()+" "
									+sp.getLastName()+"\n" + "Specialization : "+sp.getSpecialization()+"\n"
									+"Experience : "+sp.getExperience()+"\n"+ "Fees : "+appSlot.getPayment().getFees()+"\n"
									+"Specialist Email Id : "+sp.getEmail());
							emailSender.send(message);
							SimpleMailMessage message1=new SimpleMailMessage();
//							message1.setFrom("swasthaoffice@gmail.com");
							message1.setTo(sp.getEmail());
							message1.setSubject("User has Successfully Booked the Slot");
							message1.setText("User Name : "+db.getFirstName()+" "+db.getLastName()+"\n"
									+ "Blood Group : "+db.getBloodGroup()+"\n"+ "Email : "+db.getEmail());
							emailSender.send(message1);
						}
					}
				}
				
				return new ResponseEntity<ResponseStructure<AppointmentDate>>(structure, HttpStatus.CREATED);
			}
			throw new SpecialistIdNotFound();
		}
		throw new UserIdNotFound();
	}
	
//	public ResponseEntity<ResponseStructure<AppointmentDate>> save(AppointmentDate appointmentDate){
//		structure.setData(dao.save(appointmentDate));
//		structure.setMessage("AppoinmentDate Saved Successfully...");
//		structure.setStatus(HttpStatus.CREATED.value());
//		return new ResponseEntity<ResponseStructure<AppointmentDate>>(structure,HttpStatus.CREATED);
//	}
	
}
