package com.restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.model.Quiz;

public interface QuizRepo extends JpaRepository<Quiz,Long>{

}
