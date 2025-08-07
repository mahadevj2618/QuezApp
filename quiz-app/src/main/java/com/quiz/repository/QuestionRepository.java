package com.quiz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.quiz.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findBySubject(String subject);
}
