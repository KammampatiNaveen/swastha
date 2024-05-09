package com.jsp.swastha.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.swastha.dto.Slot;

public interface SlotRepo extends JpaRepository<Slot, String> {

}
