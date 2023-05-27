package com.restapi.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.model.Questions;
import com.restapi.model.Quiz;
import com.restapi.model.Results;
import com.restapi.services.QuizServices;
import com.restapi.services.ResultsServices;

@RestController
@RequestMapping("/quizzes")
@CrossOrigin("*")
public class MainController {
		
	@Autowired
	private QuizServices quizServices;
	
	@Autowired
	private ResultsServices resultsServices;
	
	//add quiz
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
		Quiz quiz1=this.quizServices.addQuiz(quiz);
		return ResponseEntity.ok(quiz1);
	}
	//get quiz
	@GetMapping("/{quizId}")
	public Quiz getQuiz(@PathVariable("quizId") Long quizId) {
		return this.quizServices.getQuiz(quizId);
	}
	
	//get all quizzes
	@GetMapping("/all")
	public ResponseEntity<?> getAllQuizes(){
		return ResponseEntity.ok(this.quizServices.getQuizzes());
	}
	//update quizzes
	@PutMapping("/")
	public Quiz updateQuiz(@RequestBody Quiz quiz) {
		return this.quizServices.updateQuiz(quiz);
	}
	
	//delete quizzes
	@DeleteMapping("/{quizId}")
	public void deleteQuiz(@PathVariable("quizId") Long quizId) {
	this.quizServices.deleteQuiz(quizId);
	}
	
	//getting active quizzes
	@GetMapping("/active")
	public ResponseEntity<?> getActiveQuiz(){
		return ResponseEntity.ok(this.quizServices.isActive());
	}
	
	//evaluate quiz
	@PostMapping("/result")
	public ResponseEntity<?> result(@RequestBody List<Questions> questions){
		Results res=new Results();
		Integer mark=0;
		Integer attem=0;
		Integer incorr=0;
		Integer corr=0;
		Long id = null;
		for (Questions ques : questions) {
			id=ques.getQuiz().getqId();
			if(ques.getAnswer().trim().equals(ques.getGivenAnswer().trim())) {
				mark+=Integer.parseInt(ques.getQuiz().getMaxMarks())/Integer.parseInt(ques.getQuiz().getNoOfQuestions());
				attem++;
				corr++;
			}
			else if(ques.getAnswer()!=null&&ques.getAnswer()!="") {
				attem++;
				incorr++;	
			}
			
		}
		res.setCorrect(corr);
		res.setIncorrect(incorr);
		res.setAttempted(attem);
		res.setMarks(mark);
		res.setQuiz(this.quizServices.getQuiz(id));
		return ResponseEntity.ok(this.resultsServices.addResult(res));
	}
	
	
	@GetMapping("/:{quizId}/result")
	public ResponseEntity<?> result(@PathVariable("quizId") Long quizId){
		
		Quiz quiz=this.quizServices.getQuiz(quizId);
		Set<Results> result=quiz.getResults();
		
		List<Results> list=new ArrayList<>(result);
		
		return ResponseEntity.ok(list);
	}
	
}
