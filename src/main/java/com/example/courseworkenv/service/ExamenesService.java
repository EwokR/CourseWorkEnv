package com.example.courseworkenv.service;

import com.example.courseworkenv.Question;

import java.util.Collection;

public interface ExamenesService {
    Collection<Question> getQuestions(int amount);
}
