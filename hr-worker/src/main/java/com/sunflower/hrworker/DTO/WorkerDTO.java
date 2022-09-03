package com.sunflower.hrworker.DTO;

import java.io.Serializable;

import com.sunflower.hrworker.entities.Worker;

public class WorkerDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Double dailyIncome;
	
	public WorkerDTO() {
		
	}

	public WorkerDTO(Worker entity) {
		id = entity.getId();;
		name = entity.getName();
		dailyIncome = entity.getDailyIncome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDailyIncome() {
		return dailyIncome;
	}

	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}
	
}
