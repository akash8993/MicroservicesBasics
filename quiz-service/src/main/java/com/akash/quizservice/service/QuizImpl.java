package com.akash.quizservice.service;

import com.akash.quizservice.entity.Question;
import com.akash.quizservice.entity.Quiz;
import com.akash.quizservice.feign.ApiClient;
import com.akash.quizservice.repo.QuizRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizImpl implements QuizService{

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private ApiClient apiClient;
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public List<Quiz> getAll() {
        List<Quiz> allQuiz= quizRepo.findAll();

        return allQuiz.stream().map(quiz -> {
            quiz.setQuestions(apiClient.findByQuizId(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
    }

    @Override
    public Quiz get(Long id) {

        Quiz quiz=quizRepo.findById(id).orElseThrow(()-> new RuntimeException("Quiz not found"));
        quiz.setQuestions(apiClient.findByQuizId(quiz.getId()));
        return quiz;
    }
}
