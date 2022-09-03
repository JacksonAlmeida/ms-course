package com.sunflower.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunflower.hrworker.DTO.WorkerDTO;
import com.sunflower.hrworker.services.WorkerService;

@RestController
@RequestMapping(value = "/api/hr-worker/workers")
public class WorkerResource {

	@Autowired
	private WorkerService workerService;

	@GetMapping
	public ResponseEntity<List<WorkerDTO>> findAll() {
		List<WorkerDTO> dtoList = workerService.findAll();
		return ResponseEntity.ok().body(dtoList);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<WorkerDTO> findById(@PathVariable long id) {
		WorkerDTO dto = workerService.findById(id);
		return ResponseEntity.ok().body(dto);
	}

}
