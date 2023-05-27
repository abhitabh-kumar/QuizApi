package com.restapi.services.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.model.Quiz;
import com.restapi.repo.QuizRepo;
import com.restapi.services.QuizServices;

@Service
public class QuizServiceImpl implements QuizServices{
	

	@Autowired
	private QuizRepo quizRepo;
	
	
	@Override
	public Set<Quiz> isActive() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.quizRepo.findAll().stream().filter(q->q.isActive()).collect(Collectors.toList()));
	}

	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepo.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepo.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.quizRepo.findAll());
	}

	@Override
	public Quiz getQuiz(Long quizid) {
		// TODO Auto-generated method stub
		return this.quizRepo.findById(quizid).get();
	}

	@Override
	public void deleteQuiz(Long quizId) {
		// TODO Auto-generated method stub
		Quiz quiz=new Quiz();
		quiz.setqId(quizId);
		this.quizRepo.delete(quiz);
	}
	
		
}
