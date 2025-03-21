package com.emmanuel.todoapi;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;


@Controller//@RestController has @ResponseBody annotation and would not work for JSP
@SessionAttributes("username")
public class TodoControllerJpa {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private TodoRepository todoRepository;

//    private TodoService todoService;
    public TodoControllerJpa( TodoRepository todoRepository) {
//        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @RequestMapping("/todos")
    public String listAllTodos(ModelMap model) {
        String username = getLoggedInUsername(model);


        List<Todo> todos = todoRepository.findByUsername(username);
//        logger.info("Todos: {}", todos);
//        System.out.println("Todos: " + todos);
        model.addAttribute("todos", todos);
        return "listTodos";
    }



    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String addTodo(ModelMap model) {
        //We pass an obj of ttodo to the view so that the form can bind to it and send it back to the server. This is called form backing object which is an alternative to using @RequestParam
        String username = getLoggedInUsername(model);
        //logger.info("Username: {}", username);
        Todo todo = new Todo(0, username, "", false, LocalDate.now());
        model.put("todo", todo);//The jsp form will bind to this object with the name todo
        return "addTodo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodoPost(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "addTodo";
        }

        //String username = "emmanuel";
        //TODO pass username from session
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
//        logger.info("Username: {}", username);
        todoRepository.save(todo);
//        todoService.addTodo(username,ttodo.getDescription(),ttodo.isDone(), ttodo.getDateline());


        return "redirect:/todos";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        todoRepository.deleteById(id);
        return "redirect:/todos";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String updateTodo(@RequestParam int id, ModelMap model) {
        Todo todo = todoRepository.findById(id).get();
        model.put("todo", todo);
        return "updateTodo";
    }
    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodoPost(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "updateTodo";
        }
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:/todos";
    }

    private String getLoggedInUsername(ModelMap model) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
