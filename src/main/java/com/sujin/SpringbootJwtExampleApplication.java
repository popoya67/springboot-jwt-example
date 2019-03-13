package com.sujin;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sujin.app.dto.User;
import com.sujin.app.service.JwtService;

@SpringBootApplication
public class SpringbootJwtExampleApplication implements CommandLineRunner{
	
	@Autowired
	private JwtService jwtService; 
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootJwtExampleApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJwtExampleApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		User u = new User();
		u.setUserId("sujin");
		u.setName("이수진");
		u.setAuthority(Arrays.asList("USER"));
		
		LOGGER.debug("creating jwt...");
		
		String token = jwtService.createLoginToken(u);
		LOGGER.debug("created jwt ::::::: {}" , token);
		
		
		LOGGER.debug("jwt decoding... ");
		User user = jwtService.getUser(token);
		LOGGER.debug("decoded jwt ::::::: {}", user);
	}

}
