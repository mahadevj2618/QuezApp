package com.quiz.entity;

import jakarta.persistence.*;

@Entity
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;  // Java, Python, etc.
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(Long id, String subject, String question, String optionA, String optionB, String optionC,
			String optionD, String correctAnswer) {
		super();
		this.id = id;
		this.subject = subject;
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.correctAnswer = correctAnswer;
	}
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
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", subject=" + subject + ", question=" + question + ", optionA=" + optionA
				+ ", optionB=" + optionB + ", optionC=" + optionC + ", optionD=" + optionD + ", correctAnswer="
				+ correctAnswer + "]";
	}

    // getters and setters
    
}
