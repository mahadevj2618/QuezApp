package com.quiz.services;

import com.quiz.entity.User;

public interface UserService {
	void registerUser(User user);
    User login(String email, String password);
}
