package com.restapi.services;

import java.util.Set;

import com.restapi.model.Results;


public interface ResultsServices {

	public Results addResult(Results results);
	
	public Results updateResult(Results results);
	
	public Set<Results> getResults();
	
	public Results getResult(Long resId);
	
	public void deleteResult(Long resId);
	
}
