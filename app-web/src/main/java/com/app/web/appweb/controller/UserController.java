package com.app.web.appweb.controller;

import com.app.web.appweb.model.User;
import com.app.web.appweb.service.UserService;
import com.app.web.appweb.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//MVC controller
@Controller
public class UserController {

    @Autowired
    ValidationService validationService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String showHome(ModelMap model) {
        return "redirect:/list-users";
    }

    // http://localhost:8080/list-users
    @GetMapping("/list-users")
    public String showAll(ModelMap model) {
        model.put("users", userService.findAll());
        return "list-users";
    }

    // http://localhost:8080/add-user
    @GetMapping("/add-user")
    public String showAddPage(ModelMap model) {
        model.addAttribute("user", new User("", "", "", "", "", ""));
        return "user";
    }

    // http://localhost:8080/add-user
    @PostMapping("/add-user")
    public String add(ModelMap model, @ModelAttribute("user") User u, BindingResult result) {
        if(result.hasErrors()) {
            return "user";
        }

        //validate
        if (!isUserDataValid(model, u)) return "user";

        userService.add(u);
        return "redirect:/list-users";
    }

    @GetMapping("/update-user/{id}")
    public String showUpdatePage(ModelMap model, @PathVariable int id) {
        model.addAttribute("user", userService.findById(id));
        return "user";
    }

    @PostMapping("/update-user/{id}")
    public String update(ModelMap model, @ModelAttribute("user") User u, BindingResult result) {
        if(result.hasErrors()) {
            return "user";
        }

        //validate
        if (!isUserDataValid(model, u)) return "user";

        userService.update(u);
        return "redirect:/list-users";
    }

    private boolean isUserDataValid(ModelMap model, User u) {
        try {
            if (!validationService.isPhoneValid(u.getPhoneNum())) {
                model.put("status", "Failed to save user.");
                model.put("reason", "Invalid Phone Number!");
                return false;
            }

            if (!validationService.isEmailValid(u.getEmail())) {
                model.put("status", "Failed to save user.");
                model.put("reason", "Invalid Email!");
                return false;
            }

            if (!validationService.isPassValid(u.getPassword())) {
                model.put("status", "Failed to save user.");
                model.put("reason", "Invalid Password!");
                return false;
            }
        }
        catch (Exception e){
            model.put("status", "Failed to save user.");
            model.put("reason", e.getMessage());
            return false;
        }
        return true;
    }

    @GetMapping("/delete-user/{id}")
    public String delete(@PathVariable int id) {
        userService.deleteById(id);
        return "redirect:/list-users";
    }
}
