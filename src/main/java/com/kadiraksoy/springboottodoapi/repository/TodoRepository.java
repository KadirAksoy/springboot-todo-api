package com.kadiraksoy.springboottodoapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo,> {
}
