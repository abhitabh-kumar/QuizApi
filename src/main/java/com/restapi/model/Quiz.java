package com.restapi.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Quiz {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long qId;
		
		private String maxMarks;
		
		private String noOfQuestions;
		
		private boolean active=false;
		
		
		@OneToMany(mappedBy="quiz",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
		@JsonIgnore
		private Set<Questions> questions=new HashSet<>();
		
		@OneToMany(mappedBy="quiz",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
		@JsonIgnore
		private Set<Results> results=new HashSet<>();
		
		
		public Set<Results> getResults() {
			return results;
		}

		public void setResults(Set<Results> results) {
			this.results = results;
		}

		public Set<Questions> getQuestions() {
			return questions;
		}

		public void setQuestions(Set<Questions> questions) {
			this.questions = questions;
		}

		public Quiz() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Long getqId() {
			return qId;
		}

		public void setqId(Long qId) {
			this.qId = qId;
		}

		public Quiz(Long qId, String maxMarks, String noOfQuestions, boolean active) {
			super();
			this.qId = qId;
			this.maxMarks = maxMarks;
			this.noOfQuestions = noOfQuestions;
			this.active = active;
		}

		public String getMaxMarks() {
			return maxMarks;
		}

		public void setMaxMarks(String maxMarks) {
			this.maxMarks = maxMarks;
		}

		public String getNoOfQuestions() {
			return noOfQuestions;
		}

		public void setNoOfQuestions(String noOfQuestions) {
			this.noOfQuestions = noOfQuestions;
		}

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}

		
	
}
