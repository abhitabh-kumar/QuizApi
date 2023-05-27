package com.restapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Results {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rId;
	
	private Integer marks;
	
	private Integer attempted;
	
	private Integer incorrect;
	
	private Integer correct;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Quiz quiz;
		
	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Long getrId() {
		return rId;
	}

	public void setrId(Long rId) {
		this.rId = rId;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public Integer getAttempted() {
		return attempted;
	}

	public void setAttempted(Integer attempted) {
		this.attempted = attempted;
	}

	public Integer getIncorrect() {
		return incorrect;
	}

	public void setIncorrect(Integer incorrect) {
		this.incorrect = incorrect;
	}

	public Integer getCorrect() {
		return correct;
	}

	public void setCorrect(Integer correct) {
		this.correct = correct;
	}
	
}
