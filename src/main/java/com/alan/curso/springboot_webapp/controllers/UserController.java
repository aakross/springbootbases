package com.alan.curso.springboot_webapp.controllers;

import com.alan.curso.springboot_webapp.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Alan", "Antonio");
        user.setEmail("alan@correo.com");
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
//        List<User> users = Arrays.asList(
//                new User("Pepa", "Gonzales"),
//                new User("Lalo", "Perez", "lalo@correo.com"),
//                new User("Juanita", "Roe")
//        );

//        model.addAttribute("users", users);
        model.addAttribute("title", "Listado de usuarios");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> userModel() {
        List<User> users = Arrays.asList(
                new User("Pepa", "Gonzales"),
                new User("Lalo", "Perez", "lalo@correo.com"),
                new User("Juanita", "Roe")
        );
        return users;
    }
}
