package com.emmanuel.todoapi;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static int todoCount = 0;
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(todoCount++, "Emmanuel", "Learn Java", false, LocalDate.now().plusYears(1)));
        todos.add(new Todo(todoCount++, "Emmanuel", "Learn Spring", false, LocalDate.now().plusYears(1)));
        todos.add(new Todo(todoCount++,"Emmanuel", "Learn Spring Boot", false, LocalDate.now().plusYears(1)));
        todos.add(new Todo(todoCount++,"Emmanuel", "Learn React", false, LocalDate.now().plusYears(2)));
        todos.add(new Todo(todoCount++,"Emmanuel", "Learn Spring Security", false, LocalDate.now().plusYears(2)));
    }

    public List<Todo> findByUsername(String username) {
//        System.out.println("Todos: " + todos);
        return todos;
    }

    public void addTodo(String username, String description, LocalDate dateline) {
        Todo todo = new Todo(todoCount++, username, description, false, dateline);
        todos.add(todo);
    }

    public void deleteTodoById(int id) {
        todos.removeIf(todor -> todor.getId() == id);
    }

    public Todo findById(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst().orElse(null);
    }

    public void updateTodo(Todo todo) {
        todos.removeIf(todor -> todor.getId() == todo.getId());
        todos.add(todo);
    }
}
