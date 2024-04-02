package com.akash.quizservice.entity;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Question {

    private Long questionId;

    private String question;

    private Long quizId;
}
