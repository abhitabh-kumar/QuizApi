package com.restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.model.Results;

public interface ResultsRepo extends JpaRepository<Results,Long>{

}
