package com.kadiraksoy.springboottodoapi.repository;

import com.kadiraksoy.springboottodoapi.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends MongoRepository<Todo, String> {

    List<Todo> findAllByUserId(String userId);

    Optional<Todo> findByIdAndUserId(String id, String userId);
}
