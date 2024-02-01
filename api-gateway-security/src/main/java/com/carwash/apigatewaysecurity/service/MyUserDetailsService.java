package com.carwash.apigatewaysecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.carwash.apigatewaysecurity.models.LoginResponse;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	RestTemplate restTemplate;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        
    	LoginResponse loginResponse=restTemplate.getForObject("http://user-service/user/username/"+userName, LoginResponse.class);
    	GrantedAuthority auth=new SimpleGrantedAuthority(loginResponse.getUserRole());
    	ArrayList<GrantedAuthority> list=new ArrayList<GrantedAuthority>();
    	list.add(auth);
    	UserDetails userDetails=new User(loginResponse.getUserName(),
    			loginResponse.getPassword(), list);
    	return userDetails;
    }
}