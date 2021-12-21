package com.todos.controllers;

import com.todos.models.Todo;
import com.todos.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<Todo> getAll(){
        return todoService.findAllTodos();
    }

    @GetMapping("/{todoId}")
    public Todo getTodoById(@PathVariable Long todoId){
        return todoService.findTodoById(todoId);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }

    @PutMapping("/{todoId}")
    public Todo updateTodo(@PathVariable Long todoId, Todo todo){
        return todoService.updateTodo(todoId, todo);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long todoId){
        return todoService.deleteTodoById(todoId);
    }
}
