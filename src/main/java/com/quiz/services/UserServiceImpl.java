package com.quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entity.User;
import com.quiz.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public void registerUser(User user) {
		userRepo.save(user);
		
	}

	@Override
	public User login(String email, String password) {
		User u=userRepo.findByEmail(email);
		if(u!=null && u.getPassword().equals(password)) {
		return u;
		}
		return null;
	}

}
