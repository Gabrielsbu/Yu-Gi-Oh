package com.todos.services.impl;

import com.todos.models.Todo;
import com.todos.repositories.TodoRepository;
import com.todos.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        return todoRepository.findById(todoId).orElseThrow();
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Long todoId, Todo todo) {
        Todo todoExistent = todoRepository.getById(todoId);
        todoExistent.setDone(false);
        todoExistent.setExpired(false);
        todoExistent.setNumberDays(todo.getNumberDays());
        todoExistent.setDateExpired(LocalDateTime.now().plusDays(todo.getNumberDays()));
        todoExistent.setDescription(todo.getDescription());

        return todoRepository.save(todoExistent);
    }

    @Override
    public ResponseEntity<Void> deleteTodoById(Long todoId) {
        Todo todoExistent = findTodoById(todoId);

        todoRepository.deleteById(todoExistent.getTodoId());

        return ResponseEntity.noContent().build();
    }
}
