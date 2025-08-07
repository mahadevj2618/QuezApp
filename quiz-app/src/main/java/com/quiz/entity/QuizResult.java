package com.quiz.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.*;

@Entity
public class QuizResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private int score;

    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public QuizResult() {}

    public QuizResult(String subject, int score, LocalDateTime dateTime, User user) {
        this.subject = subject;
        this.score = score;
        this.dateTime = dateTime;
        this.user = user;
    }

    // Getters and setters
    
 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	   // Add getDaysAgo method if you want to calculate how old the quiz is
    public long getDaysAgo() {
        return ChronoUnit.DAYS.between(dateTime.toLocalDate(), LocalDate.now());
    }

	@Override
	public String toString() {
		return "QuizResult [id=" + id + ", subject=" + subject + ", score=" + score + ", dateTime=" + dateTime
				+ ", user=" + user + "]";
	}
    
}
