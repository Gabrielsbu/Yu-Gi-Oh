package com.todos.services.impl;

import com.todos.models.Todo;
import com.todos.services.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TodoServiceImpl implements TodoService {

    @Override
    public Set<Todo> findAllTodos() {
        return null;
    }

    @Override
    public Todo findTodoById(Long todoId) {
        return null;
    }

    @Override
    public Todo createTodo(Todo todo) {
        return null;
    }

    @Override
    public Todo updateTodo(Long todoId, Todo todo) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteTodoById(Long todoId) {
        return null;
    }
}
