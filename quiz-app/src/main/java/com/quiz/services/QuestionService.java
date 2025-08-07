package com.quiz.services;

import java.util.List;
import com.quiz.entity.Question;

public interface QuestionService {
    List<Question> getQuestionsBySubject(String subject);
}
