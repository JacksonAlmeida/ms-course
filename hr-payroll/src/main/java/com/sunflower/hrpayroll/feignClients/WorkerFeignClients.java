package com.sunflower.hrpayroll.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sunflower.hrpayroll.entities.WorkerDTO;

@Component
@FeignClient(name = "hr-worker", /*url = "lb://hr-worker",*/ path = "/workers")
public interface WorkerFeignClients {

	@GetMapping(value = "/{id}")
	ResponseEntity<WorkerDTO> findById(@PathVariable long id);
	
}
