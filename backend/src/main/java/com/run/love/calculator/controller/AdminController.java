package com.run.love.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @RequestMapping("/results")
    public String results() {
        return "results";
    }
}