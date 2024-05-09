package com.jsp.swastha.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.jsp.swastha.util.CustomIdGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Specialist {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "specialist_seq")
	@GenericGenerator(name = "specialist_seq", strategy = "com.jsp.swastha.util.CustomIdGenerator", parameters = {
			@Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "Specialist_"),
			@Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String spe_id;
	private String firstname;
	private String lastName;
	@Column(unique = true)
	private String email;
	private String password;
	private String confirmPassword;
	private long phone;
	private String specialization;
	private String experience;
	private int age;
	private String admin;
	private String gender;
	private double fees;

	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@ManyToMany(mappedBy = "specialists",fetch = FetchType.EAGER)
	private List<User> users;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<AppointmentDate> appointmentDates;
	
}
