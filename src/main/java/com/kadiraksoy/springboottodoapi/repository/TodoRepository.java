package com.kadiraksoy.springboottodoapi.repository;

import com.kadiraksoy.springboottodoapi.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> {
}
