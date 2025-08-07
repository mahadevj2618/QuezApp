package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // ✅ ADD THIS
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.quiz.entity.QuizResult;
import com.quiz.entity.User;
import com.quiz.repository.QuizResultRepository;
import com.quiz.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;
   

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute User user) {
        userService.registerUser(user);
        return "login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
    



    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session) {
        User u = userService.login(email, password);
        if (u != null) {
            session.setAttribute("user", u);  // Store full user, not just email
            return "dashboard";
        }
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login"; // block if not logged in
        }
        model.addAttribute("user", user);
        return "dashboard";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
    
    @Autowired
    private QuizResultRepository quizResultRepo;

    @GetMapping("/profile")
    public String showProfile(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<QuizResult> results = quizResultRepo.findByUser(user);

        model.addAttribute("user", user);
        model.addAttribute("results", results);

        return "profile";
    }


}
