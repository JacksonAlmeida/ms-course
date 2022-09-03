package com.sunflower.hrworker.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunflower.hrworker.DTO.WorkerDTO;
import com.sunflower.hrworker.entities.Worker;
import com.sunflower.hrworker.repositories.WorkerRepository;
import com.sunflower.hrworker.services.exceptions.ResourceNotFoundException;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository workerRepository;

	public List<WorkerDTO> findAll() {
		List<Worker> list = workerRepository.findAll();
		List<WorkerDTO> dto = list.stream().map(x -> new WorkerDTO(x)).collect(Collectors.toList());
		return dto;
	}

	public WorkerDTO findById(long id) {
		Optional<Worker> obj = workerRepository.findById(id);
		if (obj.isPresent()) {
			return obj.stream().map(x -> new WorkerDTO(x)).findAny().get();
		}
		else {
			Optional<WorkerDTO> dto = Optional.empty();
			return dto.orElseThrow(() -> new ResourceNotFoundException(id));
		}
	}

}
