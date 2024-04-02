package com.akash.quizservice.controller;

import com.akash.quizservice.entity.Quiz;
import com.akash.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(quizService.addQuiz(quiz));

    }

    @GetMapping("/getQuiz/{quizId}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable Long quizId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(quizService.get(quizId));
    }


}
