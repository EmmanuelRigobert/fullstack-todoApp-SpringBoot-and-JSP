package com.emmanuel.todoapi;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Controller//@RestController has @ResponseBody annotation and would not work for JSP
@SessionAttributes("username")
public class TodoController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private TodoService todoService;
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("emmanuel");
//        logger.info("Todos: {}", todos);
//        System.out.println("Todos: " + todos);
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String addTodo(ModelMap model) {
        //We pass an obj of ttodo to the view so that the form can bind to it and send it back to the server. This is called form backing object which is an alternative to using @RequestParam
        String username = (String)model.get("username");
        logger.info("Username: {}", username);
        Todo todo = new Todo(0, username, "", false, LocalDate.now());
        model.put("todo", todo);//The jsp form will bind to this object with the name todo
        return "addTodo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodoPost(ModelMap model, @Valid Todo todo, BindingResult result) {
        //String username = "emmanuel";
        //TODO pass username from session
        String username = (String)model.get("username");
//        logger.info("Username: {}", username);
        todoService.addTodo(username,todo.getDescription(), todo.getDateline());

        if(result.hasErrors()) {
            return "addTodo";
        }

        return "redirect:/todos";
    }
}
