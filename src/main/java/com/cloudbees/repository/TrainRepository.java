package com.cloudbees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloudbees.model.TicketsEntity;
import com.cloudbees.model.TrainEntity;

@Repository
public interface TrainRepository extends JpaRepository<TrainEntity, Integer>{

}
