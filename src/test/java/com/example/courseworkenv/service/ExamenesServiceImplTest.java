package com.example.courseworkenv.service;

import com.example.courseworkenv.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExamenesServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionServiceMock;

    @InjectMocks
    private ExamenesServiceImpl examenesServiceImpl;


    @Test
    public void qetQuestionsTest() {
        Question question1 = new Question("test question one", "test answer one");
        Question question2 = new Question("test question two", "test answer two");
        Question question3 = new Question("test question three", "test answer three");
        Question question4 = new Question("test question four", "test answer four");
        Question question5 = new Question("test question five", "test answer five");
        Collection<Question> questions = new HashSet<>(Set.of(question1, question2, question3, question4, question5));
        when(javaQuestionServiceMock.getAll()).thenReturn(questions);
        when(javaQuestionServiceMock.getAll().size()).thenReturn(5);
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(question1, question2, question3, question4, question5);
        examenesServiceImpl.getQuestions(5);
        verify(javaQuestionServiceMock,times(5)).getRandomQuestion();
    }
}
