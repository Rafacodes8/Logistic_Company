/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rmoriana
 */
@Controller
public class HelloWorldController {
    
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("message", "hello World");
        return "helloworld";
    }
    
    @GetMapping("/style")
    public String style() {
        return "add-css-js-demo";
    }
    
    @GetMapping("/bootstrap")
    public String bootstrap() {
        return "add-bootstrap";
    }
}
    
    

