package com.felix.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marketplace")
public class MarketPlaceController {

    @RequestMapping("/redirect")
    public  String redirect(){
        System.out.println("redirect request get");
        return "redirect request get";
    }

    @RequestMapping("/policy")
    public  String policy(){
        System.out.println("policy request get");
        return "policy request get";
    }

    @RequestMapping("/support")
    public  String support(){
        System.out.println("support request get");
        return "support request get";
    }

    @RequestMapping("/configure")
    public  String configure(){
        System.out.println("configure request get");
        return "configure request get";
    }

    @RequestMapping("/deauthorization")
    public  String deauthorization(){
        System.out.println("deauthorization request get");
        return "deauthorization request get";
    }
}
