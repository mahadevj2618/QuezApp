package com.quiz.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quiz.entity.Question;
import com.quiz.repository.QuestionRepository;
import com.quiz.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepo;

    @Override
    public List<Question> getQuestionsBySubject(String subject) {
        return questionRepo.findBySubject(subject);
    }
}
