package com.sunflower.hruser.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunflower.hruser.dto.UserDTO;
import com.sunflower.hruser.entities.User;
import com.sunflower.hruser.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> findAll() {
		List<User> obj = userRepository.findAll();
		return obj.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}

	public UserDTO findById(long id) {
		Optional<User> obj = userRepository.findById(id);
		if (obj.isPresent()) {
			return obj.stream().map(x -> new UserDTO(x)).findAny().get();
		} else
			return null;
	}

}
