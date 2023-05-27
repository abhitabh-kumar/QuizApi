package com.restapi.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.model.Results;
import com.restapi.repo.ResultsRepo;
import com.restapi.services.ResultsServices;

@Service
public class ResultsServiceImpl implements ResultsServices{

	@Autowired
	private ResultsRepo resultRepo;
	
	@Override
	public Results addResult(Results results) {
		// TODO Auto-generated method stub
		return this.resultRepo.save(results);
	}

	@Override
	public Results updateResult(Results results) {
		// TODO Auto-generated method stub
		return this.resultRepo.save(results);
	}

	@Override
	public Set<Results> getResults() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.resultRepo.findAll());
	}

	@Override
	public Results getResult(Long resId) {
		// TODO Auto-generated method stub
		return this.resultRepo.findById(resId).get();
	}

	@Override
	public void deleteResult(Long resId) {
		// TODO Auto-generated method stub
		Results result1=new Results();
		result1.setrId(resId);
		this.resultRepo.delete(result1);
		
	}

	
}
