package com.restapi.services;

import java.util.Set;

import com.restapi.model.Questions;
import com.restapi.model.Quiz;

public interface QuestionServices {
	
		public Questions addQuestion(Questions questions);
		
		public Questions updaeQuestions(Questions questions);
		
		public Set<Questions> getAllQuestions();
		
		public Questions getQuestion(Long questionId);
		
		public Set<Questions> getQuestionsOfQuiz(Quiz quiz);
		
		public void deleteQuestions(Long quesId);
}
