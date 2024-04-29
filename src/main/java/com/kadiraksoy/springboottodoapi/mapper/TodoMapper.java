package com.kadiraksoy.springboottodoapi.mapper;

import com.kadiraksoy.springboottodoapi.model.Todo;
import com.kadiraksoy.springboottodoapi.payload.payload.TodoResponseDTO;
import com.kadiraksoy.springboottodoapi.payload.request.TodoRequestDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TodoMapper {

    @Mapping(target = "completed", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "id", ignore = true)
    Todo todoRequestToTodo(TodoRequestDTO todoRequestDTO);

    TodoResponseDTO todoToTodoResponse(Todo todo);

    TodoRequestDTO todoToTodoRequest(Todo todo);
}