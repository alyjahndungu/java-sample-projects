package com.springweb.springlogin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class MainController {
    @GetMapping("/webapp")
    public String home1(){

        return "home";
    }

    @RequestMapping(value = "/home")
    public String home(){

        return "home";
    }

    @GetMapping("/admin")
    public String admin(){
        return "/admin";
    }

    @GetMapping("/user")
    public String user(){

        return "user";
    }

    @GetMapping("/about")
    public String about(){

        return "about";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/403")
    public String error403(){
        return "403";
    }

}
