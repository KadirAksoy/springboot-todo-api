package com.kadiraksoy.springboottodoapi.service;

import com.kadiraksoy.springboottodoapi.exception.TodoNotFoundException;
import com.kadiraksoy.springboottodoapi.mapper.TodoMapper;
import com.kadiraksoy.springboottodoapi.model.Todo;
import com.kadiraksoy.springboottodoapi.payload.response.TodoResponseDTO;
import com.kadiraksoy.springboottodoapi.payload.request.TodoRequestDTO;
import com.kadiraksoy.springboottodoapi.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoService   {

    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;


    public TodoResponseDTO addTodo(TodoRequestDTO todoRequestDTO) {
        var todo = todoMapper.todoRequestToTodo(todoRequestDTO);
        todo.setUserId(todoRequestDTO.getUserId());
        todo.setCompleted(false);
        todoRepository.save(todo);

        return todoMapper.todoToTodoResponse(todo);
    }



    public TodoResponseDTO editTodo(String todoId, TodoRequestDTO todoRequestDTO) {
        var exitTodo = findTodo(todoRequestDTO.getUserId(), todoId);

        var newTodoContent = todoMapper.todoRequestToTodo(todoRequestDTO);
        newTodoContent.setId(exitTodo.getId());
        newTodoContent = todoRepository.save(newTodoContent);

        return todoMapper.todoToTodoResponse(newTodoContent);
    }


    public void removeTodo(String userId, String todoId) {
        var todo = findTodo(todoId, userId);
        todoRepository.delete(todo);
    }


    public TodoResponseDTO getUserTodo(String userId, String todoId) {
        var todo = findTodo(todoId, userId);
        return todoMapper.todoToTodoResponse(todo);
    }


    public TodoResponseDTO todoComplete(String todoId) {
        var todo = todoRepository.findById(todoId).orElseThrow(() -> new TodoNotFoundException("Todo can not found !"));
        todo.setCompleted(true);
        todo = todoRepository.save(todo);

        return todoMapper.todoToTodoResponse(todo);
    }


    public List<TodoResponseDTO> getUserTodoList(String userId) {
        var todoList = todoRepository.findAllByUserId(userId);

        return todoList.stream()
                .map(todoMapper::todoToTodoResponse)
                .collect(Collectors.toList());
    }

    private Todo findTodo(String todoId, String userId) {
        return todoRepository.findByIdAndUserId(todoId, userId).orElseThrow(() -> new TodoNotFoundException("Todo can not found !"));
    }
}
