package com.example.courseworkenv.service;

import com.example.courseworkenv.Question;
import com.example.courseworkenv.exception.BadRequestQuestionException;
import com.example.courseworkenv.exception.QuestionAlreadyOnListException;
import com.example.courseworkenv.exception.QuestionNotFoundException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.HashSet;
import java.util.Set;

public class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    public void addQuestionTest1() {
        Set<Question> questions = new HashSet<>();
        Question question1 = new Question("test question one", "test answer one");
        Question question2 = new Question("test question two", "test answer two");
        Question result1 = javaQuestionService.add(question1.getQuestion(), question1.getAnswer());
        Question result2 = javaQuestionService.add(question2.getQuestion(), question2.getAnswer());
        assertThat(result1).isEqualTo(question1);
        assertThat(result2).isEqualTo(question2);
    }

    @Test
    public void addQuestionTest2() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Question("test", "test"));
    }

    @Test
    public void addQuestionTest3() {
        Set<Question> questions = new HashSet<>();
        Question question1 = new Question("test question one", "test answer one");
        Question question2 = new Question("test question two", "test answer two");
        Question result1 = javaQuestionService.add(question1);
        Question result2 = javaQuestionService.add(question2);
        assertThat(result1).isEqualTo(question1);
        assertThat(result2).isEqualTo(question2);
    }

    @Test
    public void addQuestionTest4() {
        Set<Question> questions = new HashSet<>();
        Question question1 = new Question("test question one", "test answer one");
        Question result1 = javaQuestionService.add(question1);
        assertThatExceptionOfType(QuestionAlreadyOnListException.class)
                .isThrownBy(() -> new Question("test question one", "test answer one"));
    }

    @Test
    public void removeQuestionTest1() {
        Set<Question> questions = new HashSet<>();
        Question question1 = new Question("test question one", "test answer one");
        Question question2 = new Question("test question two", "test answer two");
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        Question result = javaQuestionService.remove(question1);
        assertThat(result).isEqualTo(question1);
    }

    @Test
    public void removeQuestionTest2() {
        Set<Question> questions = new HashSet<>();
        Question question1 = new Question("test question one", "test answer one");
        Question question2 = new Question("test question two", "test answer two");
        javaQuestionService.add(question1);
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> javaQuestionService.remove(question2));
    }

    @Test
    public void getAllTest1() {
        Set<Question> questions = new HashSet<>();
        Question question1 = new Question("test question one", "test answer one");
        Question question2 = new Question("test question two", "test answer two");
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        javaQuestionService.getAll();
    }
}
