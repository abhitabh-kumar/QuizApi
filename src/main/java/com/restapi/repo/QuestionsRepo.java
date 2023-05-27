package com.restapi.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.model.Questions;
import com.restapi.model.Quiz;

public interface QuestionsRepo extends JpaRepository<Questions, Long>{

	Set<Questions> findByQuiz(Quiz quiz);

}
