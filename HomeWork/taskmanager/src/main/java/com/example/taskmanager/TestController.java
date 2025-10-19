package com.example.taskmanager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test")
    public String testThymeleaf(Model model) {
        model.addAttribute("message", "Thymeleaf работает!");
        model.addAttribute("timestamp", java.time.LocalDateTime.now());
        return "test";
    }
}