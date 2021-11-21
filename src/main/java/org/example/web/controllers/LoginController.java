package org.example.web.controllers;

import org.example.web.app.services.LoginService;
import org.example.web.dto.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.apache.log4j.Logger;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private Logger logger = Logger.getLogger(LoginController.class);
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public ModelAndView login(Model model){
        logger.info("GET /home returns login_page.html");
        model.addAttribute("loginForm", new LoginForm());
        return new ModelAndView("login_page");
    }

    @PostMapping("/auth")
    public String authenticate(LoginForm loginForm){
        if (loginService.authenticate(loginForm)){
            logger.info("login OK redirect to poem stack");
            return "redirect:/books/shelf";
        }
        else {
            logger.info("login OK redirect back to login shelf");
            return "redirect:/login";
        }
    }

    }


