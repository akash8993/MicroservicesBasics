package com.akash.quizservice.service;

import com.akash.quizservice.entity.Quiz;

import java.util.List;

public interface QuizService {

    Quiz addQuiz(Quiz quiz);

    List<Quiz> getAll();

    Quiz get(Long id);
}
