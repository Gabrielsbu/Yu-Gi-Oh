package com.todos.services.impl;

import com.todos.models.Todo;
import com.todos.repositories.TodoRepository;
import com.todos.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public List<Todo> findAllTodos() {
        return todoRepository.findAll();
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
