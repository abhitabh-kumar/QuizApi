package com.restapi.services;

import java.util.Set;

import com.restapi.model.Quiz;

public interface QuizServices {

	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz> getQuizzes();
	
	public Quiz getQuiz(Long quizid);
	
	public void deleteQuiz(Long quizId);
	
	public Set<Quiz> isActive();
}
