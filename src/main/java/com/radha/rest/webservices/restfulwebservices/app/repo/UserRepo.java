package com.radha.rest.webservices.restfulwebservices.app.repo;

import com.radha.rest.webservices.restfulwebservices.app.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
}
