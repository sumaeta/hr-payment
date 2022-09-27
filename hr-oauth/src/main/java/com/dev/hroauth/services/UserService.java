package com.dev.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.hroauth.feign.UserFeignClient;
import com.dev.hroauth.model.User;

@Service
public class UserService {

	@Autowired
	private UserFeignClient feignClient;
	
	private static Logger log = LoggerFactory.getLogger(UserService.class);
	
	public User findByEmail(String email) {
		User user = feignClient.findByEmail(email).getBody();
		
		if (user == null) {
			log.error("Email Not Found" + email);
			throw new IllegalArgumentException("Email Não Encontrado");
		}
		
		log.info("Email found: " + email);
		return user;
	}
}
