package com.todos.services;

import com.todos.models.Todo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TodoService {

    List<Todo> findAllTodos();

    Todo findTodoById(Long todoId);

    Todo createTodo(Todo todo);

    Todo updateTodo(Long todoId, Todo todo);

    ResponseEntity<Void> deleteTodoById(Long todoId);
}
