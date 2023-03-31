package com.stl.ManagerLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stl.ManagerLogin.jwt.JwtUtils;
import com.stl.ManagerLogin.model.Loginmodel;



@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("Manager")
public class ManagerController {

	@Autowired
	AuthenticationManager authmanage;

	@Autowired
	JwtUtils jwtUtils;


	//login
	@PostMapping("/authenticatetoken")
	public String authDoctor(@RequestBody Loginmodel manager){
		try {
			@SuppressWarnings("unused")

			Authentication authtoken=  authmanage.authenticate(
					new UsernamePasswordAuthenticationToken(manager.getManageremail(), manager.getPassword()));
			String token = jwtUtils.generateToken(manager.getManageremail().toString());
			return token;

		} catch (Exception e) {
			return "Login Failed";
		}
	}

}
