package com.akash.quizservice.feign;

import com.akash.quizservice.entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "QUESTION-SERVICE")
public interface ApiClient {

    @GetMapping("/api/v1/findByQuizId/{id}")
    List<Question> findByQuizId(@PathVariable Long id);
}
