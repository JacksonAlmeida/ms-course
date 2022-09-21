package com.sunflower.hruser.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunflower.hruser.dto.RoleDTO;
import com.sunflower.hruser.entities.Role;
import com.sunflower.hruser.repositories.RoleRepository;
import com.sunflower.hruser.services.exceptions.ResourceNotFoundException;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public List<RoleDTO> findAll() {
		List<Role> role = roleRepository.findAll();
		return role.stream().map(x -> new RoleDTO(x)).collect(Collectors.toList());
	}

	public RoleDTO findById(long id) {
		Optional<Role> obj = roleRepository.findById(id);
		if (obj.isPresent()) {
			return obj.stream().map(x -> new RoleDTO(x)).findAny().get();
		} else {
			Optional<RoleDTO> dto = Optional.empty();
			return dto.orElseThrow(() -> new ResourceNotFoundException(id));
		}
	}

}
