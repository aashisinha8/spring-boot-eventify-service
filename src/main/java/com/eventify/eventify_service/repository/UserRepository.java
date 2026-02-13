package com.eventify.eventify_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.eventify.eventify_service.model.User;

public interface UserRepository extends MongoRepository<User, String> {
}
