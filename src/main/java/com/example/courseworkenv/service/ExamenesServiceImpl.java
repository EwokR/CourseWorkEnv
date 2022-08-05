package com.example.courseworkenv.service;

import com.example.courseworkenv.Question;
import com.example.courseworkenv.exception.BadRequestQuestionException;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExamenesServiceImpl implements ExamenesService {

    QuestionService questionService;
    JavaQuestionService javaQuestionService;

    @Override
   public Collection<Question> getQuestions(int amount) {
        Set<Question> questionSet = new HashSet<>();
        if (amount < 0 || amount > javaQuestionService.getAll().size()) {
            throw new BadRequestQuestionException();
        }

        while (questionSet.size() < amount) {
            questionSet.add(javaQuestionService.getRandomQuestion());
        }
        return questionSet;
    }
}
