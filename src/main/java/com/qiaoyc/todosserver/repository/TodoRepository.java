package com.qiaoyc.todosserver.repository;

import com.qiaoyc.todosserver.model.Todo;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


@Repository
@Primary
public interface TodoRepository extends ReactiveMongoRepository<Todo, String>{
    
}
