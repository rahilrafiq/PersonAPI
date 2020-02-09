package com.ebi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebi.controller.dto.UserDto;
import com.ebi.security.JwtUtil;
import com.ebi.security.model.JwtResponse;

/**
 * @author rahil Sign in Controller
 */
@RestController
public class SignInController {
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * Gets the User login info
	 * 
	 * @param UserDto
	 * @return response
	 */
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ResponseEntity<JwtResponse> signin(@RequestBody UserDto userDto) {
		JwtResponse jwtResponse = new JwtResponse();

		try {
			// authenticate
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUser(), userDto.getPassword()));

			String jwt = null;

			// Generate Token
			jwt = jwtUtil.generateToken(authentication.getName());

			// Set Token in response
			jwtResponse = new JwtResponse(jwt);
		} catch (BadCredentialsException e) {
			jwtResponse = new JwtResponse(e.getMessage());
		} catch (Exception e) {
			jwtResponse = new JwtResponse(e.getMessage());
		}
		return ResponseEntity.ok().body(jwtResponse);
	}

}
