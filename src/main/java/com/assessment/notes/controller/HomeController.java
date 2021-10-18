package com.assessment.notes.controller;

import com.assessment.notes.domain.User;
import com.assessment.notes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index() {return "index";}

    @RequestMapping("/login")
    public String login(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        model.addAttribute(user);
        return "userNotes";
    }


}
