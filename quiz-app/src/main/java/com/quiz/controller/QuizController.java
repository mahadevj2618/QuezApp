package com.quiz.controller;

import com.quiz.entity.Question;
import com.quiz.entity.QuizResult;
import com.quiz.entity.User;
import com.quiz.repository.QuizResultRepository;
import com.quiz.services.QuestionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class QuizController {

    @Autowired
    private QuestionService questionService;
    
    @Autowired
    private QuizResultRepository quizResultRepo;

    @GetMapping("/quiz/{subject}")
    public String startQuiz(@PathVariable String subject, Model model) {
        List<Question> questions = questionService.getQuestionsBySubject(subject);
        model.addAttribute("questions", questions);
        return "quiz";
    }
    
    @PostMapping("/submit-quiz")
    public String submitQuiz(HttpServletRequest request, HttpSession session, Model model) {
        int score = 0;
        int totalQuestions = Integer.parseInt(request.getParameter("total"));

        for (int i = 0; i < totalQuestions; i++) {
            String userAnswer = request.getParameter("answers[" + i + "]");
            String correctAnswer = request.getParameter("correctAnswers[" + i + "]");

            if (userAnswer != null && userAnswer.equals(correctAnswer)) {
                score++;
            }
        }

        // Score percentage
        double percentage = (score * 100.0) / totalQuestions;
        model.addAttribute("percentage", percentage);
        model.addAttribute("score", score);
        model.addAttribute("total", totalQuestions);

        // Get subject from hidden field
        String subject = request.getParameter("subject");

        // Get current user from session
        User user = (User) session.getAttribute("user");

        if (user != null) {
            QuizResult result = new QuizResult(subject, score, LocalDateTime.now(), user);
            quizResultRepo.save(result);
        }

        return "result"; // Make sure result.html exists
    }


}
