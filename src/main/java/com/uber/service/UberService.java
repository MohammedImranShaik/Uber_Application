package com.uber.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.uber.dto.UberDTO;

public interface UberService extends UserDetailsService {
	
	void saveUber(UberDTO uberDTO);
	
	Boolean findByEmail(String email);

}
