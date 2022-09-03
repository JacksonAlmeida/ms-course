package com.sunflower.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunflower.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
