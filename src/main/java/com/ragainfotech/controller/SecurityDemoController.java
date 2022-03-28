package com.ragainfotech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SecurityDemoController {

    @GetMapping()
    public String status(){
        return "Hello Guys, application is UP!!!!";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello Sudesh";
    }

    @GetMapping("/hello/Admin")
    public String helloAdmin(){
        return "Hello Admin";
    }



}
