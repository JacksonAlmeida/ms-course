package com.sunflower.hrworker.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sunflower.hrworker.DTO.WorkerDTO;
import com.sunflower.hrworker.entities.Worker;
import com.sunflower.hrworker.services.WorkerService;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	@Autowired
	private WorkerService workerService;

	@PostMapping(value = "/newworker")
	public ResponseEntity<Void> save(@RequestBody WorkerDTO obj){
		Worker worker = new Worker();
		BeanUtils.copyProperties(obj, worker);
		workerService.insert(worker);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
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

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		workerService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/updateworker/{id}")
	public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Worker obj){
		obj = workerService.update(id, obj);
		return ResponseEntity.ok().build();
	}
}
