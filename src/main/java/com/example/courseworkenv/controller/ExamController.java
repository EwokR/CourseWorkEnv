package com.example.courseworkenv.controller;

import com.example.courseworkenv.Question;
import com.example.courseworkenv.service.ExamenesService;
import com.example.courseworkenv.service.ExamenesServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExamenesService examenesService;

    public ExamController(ExamenesService examenesService) {
        this.examenesService = examenesService;
    }

    @GetMapping("/exam/get/{amount}")
    public Collection<Question> getQuestions(@RequestParam ("amount") int amount) {
        return  examenesService.getQuestions(amount);
    }
}
