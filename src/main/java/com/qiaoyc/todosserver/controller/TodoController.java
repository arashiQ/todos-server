package com.qiaoyc.todosserver.controller;

import com.qiaoyc.todosserver.model.Todo;
import com.qiaoyc.todosserver.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class TodoController {
    
    private final TodoRepository todoRepository;
    
    @GetMapping("/")
    public String hello(){
        return "hello Webflux!";
    }
    
    @PostMapping("/todos")
    public Mono<Void> add(@RequestBody Publisher<Todo> todo){
        return todoRepository.insert(todo).then();    
    }
    
    @GetMapping("/todos/{id}")
    public Mono<Todo> getById(@PathVariable String id){
        return todoRepository.findById(id);
    }

    @GetMapping("/todos")
    public Flux<Todo> list(){
        return todoRepository.findAll();
    }

    @DeleteMapping("/todos/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return todoRepository.deleteById(id).then();
    }
}
