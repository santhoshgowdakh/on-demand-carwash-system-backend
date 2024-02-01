package com.carwash.apigatewaysecurity.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.carwash.apigatewaysecurity.models.AuthenticationRequest;
import com.carwash.apigatewaysecurity.models.AuthenticationResponse;
import com.carwash.apigatewaysecurity.models.User;
import com.carwash.apigatewaysecurity.service.MyUserDetailsService;
import com.carwash.apigatewaysecurity.util.JwtUtil;

@RestController
public class SpringSecurityController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/hello")
	public String firstPage() {
		return "Hello World";
	}

	@GetMapping("/car/id/{userId}")
	public User first2Page(@PathVariable int userId) {
		return restTemplate.getForObject("http://user-service/user/id/" + userId, User.class);
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		List<? extends GrantedAuthority> authList=userDetails.getAuthorities().stream().collect(Collectors.toList());
		GrantedAuthority auth=authList.get(0);
		String role=auth.toString();
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));

	}
}
