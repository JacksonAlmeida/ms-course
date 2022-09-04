package com.sunflower.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunflower.hrpayroll.entities.Payment;
import com.sunflower.hrpayroll.entities.WorkerDTO;
import com.sunflower.hrpayroll.feignClients.WorkerFeignClients;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClients feignClients;
	
	public Payment getPayment(long workerId, int days) {
		WorkerDTO workerDTO = feignClients.findById(workerId).getBody();
		return new Payment(workerDTO.getName(), workerDTO.getDailyIncome(), days);
	}
	
}
