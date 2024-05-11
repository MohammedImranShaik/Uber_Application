package com.uber.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uber.dto.UberDTO;
import com.uber.service.UberService;

@Controller
public class UberController {
	
	@Autowired
	private UberService uberService;
	
	@GetMapping("/userRegistartionPage")
	public String viewUberRegistartion() {
		return "uber";
	}
	
	@PostMapping("saveUber")
	public String saveUber(UberDTO uberDTO, Map<String, Object> map) {
		
	Boolean uberExist =	uberService.findByEmail(uberDTO.getEmail());
	if(uberExist) {
		map.put("errorMessage", "Uber User Already Exists.");
	}else {
		uberService.saveUber(uberDTO);
		map.put("message", "Uber Registration Successfully");
	}

		return "login";
	}
	
	@GetMapping("testAPIOne")
	@ResponseBody
	public String testAPIOne(String email) {
		return "Test API One With Authenticated.";
		
	}
	
	@GetMapping("testAPITwo")
	@ResponseBody
	public String testAPITwo(String email) {
		return "Test API Two with Authenticated.";
		
	}
	
	@GetMapping("testAPIThree")
	@ResponseBody
	public String testAPIThree(String email) {
		return "Test API Three without Authenticated.";
		
	}
	
	@GetMapping("testAPIFour")
	public String testAPIFour(String email) {
		return "Test API Four without Authenticated.";
	}
	
	

}
