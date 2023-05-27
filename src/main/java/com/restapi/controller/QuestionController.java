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
import com.restapi.services.QuestionServices;
import com.restapi.services.QuizServices;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionServices questionServices;
	
	@Autowired
	private QuizServices quizServices;
	
	
	//add question
	@PostMapping("/")
	public ResponseEntity<Questions> addQuestion(@RequestBody Questions question){
		return ResponseEntity.ok(this.questionServices.addQuestion(question));
	}
	
	@PutMapping("/")
	public ResponseEntity<Questions> update(@RequestBody Questions question){
		return ResponseEntity.ok(this.questionServices.addQuestion(question));
	}
	
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qid){
		Quiz quiz=this.quizServices.getQuiz(qid);
		Set<Questions> questions=quiz.getQuestions();
		
		List<Questions> list=new ArrayList<>(questions);
		
		if(list.size()>Integer.parseInt(quiz.getNoOfQuestions())) {
			list=list.subList(0,Integer.parseInt(quiz.getNoOfQuestions()+1));
		}
		//every time questions comes with shuffle
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
 	//get single question
	@GetMapping("/{quesid}")
	public Questions getQuestion(@PathVariable("quesid") Long quesId) {
		return this.questionServices.getQuestion(quesId);
	}
	
	//delete question
	@DeleteMapping("/{quesId}")
	public void deleteQuestion(@PathVariable("quesId") Long quesId) {
		this.questionServices.deleteQuestions(quesId);
	}
	
	
}
