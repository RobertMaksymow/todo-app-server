package tech.outatime.todoappserver.controllers;

import org.springframework.web.bind.annotation.*;
import tech.outatime.todoappserver.entities.Todo;
import tech.outatime.todoappserver.entities.TodoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoRepository todoRepository;
    public TodoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public List<Todo> getTodos(){
        System.out.println("GET ALL TODOS");
        return todoRepository.findAll();
    }

    @GetMapping("/{todoId}")
    public Optional<Todo> getTodo(@PathVariable("todoId") Long todoId){
        var todo = todoRepository.findById(todoId); // BECAUSE OF LOMBOK
        System.out.println("GET TO DO BY ID");
        return todo;
    }

    @PostMapping
    public Todo newTodo(@RequestBody Todo todo){
        System.out.println("New TODO ADDED!");
        return this.todoRepository.save(todo);
    }

    @PutMapping("/{todoId}")
    public Optional<Todo> updateTodo(@PathVariable("todoId") Long todoId, @RequestBody Todo updatedTodo){
        System.out.println("TODO UPDATED BY ID");
        return this.todoRepository.findById(todoId)
                .map(oldTodo -> this.todoRepository
                        .save(updatedTodo));
    }

    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable("todoId") Long todoId){
        System.out.println("TODO DELETED BY ID");
        this.todoRepository.deleteById(todoId);
    }
}
