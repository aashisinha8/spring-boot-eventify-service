package com.eventify.eventify_service.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.eventify.eventify_service.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	 Optional<User> findByEmail(String email);
}
