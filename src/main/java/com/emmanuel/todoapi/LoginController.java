package com.emmanuel.todoapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("username") //This annotation is used to store the username in the session so that it can be accessed in other controllers
public class LoginController {

//    private AuthenticationService authenticationService = new AuthenticationService(); // or we allow spring to manage this class and inject it into the controller through the constructor as shown below
    private AuthenticationService authenticationService;
    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    //http://localhost:8080/login
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    //The RequestMapping handles both GET and POST requests. When submitting th jsp form, the POST request is sent. But we don't want to handle the POST request in this method. So we use the RequestMethod.GET to handle only the GET request.
    public String loginPage() {
        //logger.info("Name: {}", name);
        //logger.debug("Name: {}", name);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST) //This method handles the POST request
    public String welcomePage(@RequestParam String username, @RequestParam String password, ModelMap model) {// ModelMap is used to pass data to the view
        model.put("username", username);
        //model.put("password", password);
        if(authenticationService.authenticate(username, password)) {
            model.put("username", username);//This stores the username in the session
            return "welcome";
        } else {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }
    }
}
