package com.restapi.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.model.Questions;
import com.restapi.model.Quiz;
import com.restapi.repo.QuestionsRepo;
import com.restapi.services.QuestionServices;


@Service
public class QuestionsSeriviceImpl implements QuestionServices{
	

	@Autowired
	private QuestionsRepo questionsRepo;

	@Override
	public void deleteQuestions(Long quesId) {
		// TODO Auto-generated method stub
		Questions question=new Questions();
		question.setQuesId(quesId);
		this.questionsRepo.delete(question);
	}
	
	@Override
	public Questions addQuestion(Questions questions) {
		// TODO Auto-generated method stub
		return this.questionsRepo.save(questions);
	}

	@Override
	public Questions updaeQuestions(Questions questions) {
		// TODO Auto-generated method stub
		return this.questionsRepo.save(questions);
	}

	@Override
	public Set<Questions> getAllQuestions() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.questionsRepo.findAll());
	}

	@Override
	public Questions getQuestion(Long questionId) {
		// TODO Auto-generated method stub
		return this.questionsRepo.findById(questionId).get();
	}

	@Override
	public Set<Questions> getQuestionsOfQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.questionsRepo.findByQuiz(quiz);
	}

}
