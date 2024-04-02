package com.akash.questionservice.service;

import com.akash.questionservice.entity.Question;

import java.util.List;

public interface QuestionService {

    Question createQuestion(Question question);

    List<Question> getAllQuestions();

    Question findQuestion(Long id);

    List<Question>findByQuizId(Long quizId);
}
