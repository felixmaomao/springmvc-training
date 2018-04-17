package com.felix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping("/sayHello")
    public  String hello(Model model){
        model.addAttribute("user","felix");
        return "index";
    }
}
