package com.cloudbees.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cloudbees.model.TicketsEntity;
import com.cloudbees.model.UsersEntity;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Integer>{
	@Query("SELECT u FROM UsersEntity u WHERE emailaddress=?1")
	Optional<UsersEntity> getUserByEmailAddress(String emailAddress);
	
	@Query("SELECT u from UsersEntity u WHERE id=?1")
	Optional<UsersEntity> getUserById(int userId);
}
