package com.vehicle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicle.model.entity.User;

@Repository
public interface UserRespository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);

	Boolean existsByEmail(String email);

}
