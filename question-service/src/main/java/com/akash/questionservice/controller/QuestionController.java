package com.akash.questionservice.controller;

import com.akash.questionservice.entity.Question;
import com.akash.questionservice.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class QuestionController {

    @Autowired
    private QuestionServiceImpl questionService;

    @PostMapping("/addQuestion")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question)
    {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.createQuestion(question));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Question>> getAll()
    {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.getAllQuestions());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Question> findByQuestionId(@PathVariable Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.findQuestion(id));
    }

    @GetMapping("/findByQuizId/{id}")
    public List<Question> findByQuizId(@PathVariable Long id)
    {
        return questionService.findByQuizId(id);
    }
}
