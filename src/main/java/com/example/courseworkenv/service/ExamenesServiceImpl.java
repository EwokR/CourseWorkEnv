package com.example.courseworkenv.service;

import com.example.courseworkenv.Question;
import com.example.courseworkenv.exception.BadRequestQuestionException;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExamenesServiceImpl implements ExamenesService {

    private final QuestionService questionService;

    public ExamenesServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questionSet = new HashSet<>();
        if (amount < 0 || amount > questionService.getAll().size()) {
            throw new BadRequestQuestionException();
        }

        while (questionSet.size() < amount) {
            questionSet.add(questionService.getRandomQuestion());
        }
        return questionSet;
    }
}
