package com.sunflower.hruser.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sunflower.hruser.dto.UserDTO;
import com.sunflower.hruser.entities.User;
import com.sunflower.hruser.repositories.UserRepository;
import com.sunflower.hruser.services.exceptions.DatabaseException;
import com.sunflower.hruser.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User insert(User user) {
		try {
			return userRepository.save(user);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public List<UserDTO> findAll() {
		List<User> obj = userRepository.findAll();
		return obj.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}

	public UserDTO findById(long id) {
		Optional<User> obj = userRepository.findById(id);
		if (obj.isPresent()) {
			return obj.stream().map(x -> new UserDTO(x)).findAny().get();
		} else {
			Optional<UserDTO> dto = Optional.empty();
			return dto.orElseThrow(() -> new ResourceNotFoundException(id));
		}
	}

	public void delete(long id) {

		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

}
