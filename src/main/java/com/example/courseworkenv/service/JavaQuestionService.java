package com.example.courseworkenv.service;

import com.example.courseworkenv.Question;
import com.example.courseworkenv.exception.QuestionAlreadyOnListException;
import com.example.courseworkenv.exception.QuestionNotFoundException;
import com.example.courseworkenv.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questionsSet;

    private final Random random = new Random();

    public JavaQuestionService() {
        this.questionsSet = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        if (questionsSet.contains(new Question(question, answer))) {
            throw new QuestionAlreadyOnListException();
        }
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questionsSet.add(question);
        System.out.println("Question " + question + " is added.");
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questionsSet.contains(question)) {
            throw new QuestionNotFoundException();
        }
        questionsSet.remove(question);
        System.out.println("Question " + question + " is removed.");
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        System.out.println("List of question " + questionsSet);
        return Collections.unmodifiableCollection(questionsSet);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questionsList = new ArrayList<>(questionsSet);
        return questionsList.get(random.nextInt(questionsSet.size()));
    }
}
