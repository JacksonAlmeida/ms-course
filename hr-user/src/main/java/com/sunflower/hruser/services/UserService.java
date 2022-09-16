package com.sunflower.hruser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunflower.hruser.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

}
