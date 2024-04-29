package com.kadiraksoy.springboottodoapi.controller;


import com.kadiraksoy.springboottodoapi.service.TodoService;
import com.kadiraksoy.springboottodoapi.payload.request.TodoRequestDTO;
import com.kadiraksoy.springboottodoapi.payload.response.TodoResponseDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/todolist")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoResponseDTO addTodo(@RequestBody @Valid TodoRequestDTO todoRequestDTO) {
        return todoService.addTodo(todoRequestDTO);
    }

    @PutMapping("/{todoId}")
    @ResponseStatus(HttpStatus.OK)
    public TodoResponseDTO editTodo(@PathVariable String todoId, @RequestBody @Valid TodoRequestDTO todoRequestDTO) {
        return todoService.editTodo(todoId, todoRequestDTO);
    }

    @DeleteMapping("/todo/{todoId}/user/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable String todoId,
                           @PathVariable String userId) {
        todoService.removeTodo(userId, todoId);
    }

    @GetMapping("/todo/{todoId}/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public TodoResponseDTO getTodo(@PathVariable String todoId,
                                   @PathVariable String userId) {
        return todoService.getUserTodo(userId, todoId);
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<TodoResponseDTO> getAllUserTodo(@PathVariable String userId) {
        return todoService.getUserTodoList(userId);
    }

    @PutMapping("/todo/{todoId}")
    @ResponseStatus(HttpStatus.OK)
    public TodoResponseDTO completeTodo(@PathVariable String todoId) {
        return todoService.todoComplete(todoId);
    }
}
