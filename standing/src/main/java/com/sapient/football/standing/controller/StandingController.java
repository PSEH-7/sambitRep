package com.sapient.football.standing.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;



import com.sapient.football.standing.vo.StandingVO;

import com.sapient.football.standing.services.StandingService;



@RestController



public class StandingController {

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	

	@Autowired

	private StandingService service;

	@RequestMapping("/standing")

	    public StandingVO getStandings(@RequestParam("countryName") String countryName,

	    		                 @RequestParam("leagueName") String leagueName,

	    		                 @RequestParam("teamName") String teamName) {

		

		

	        return service.getStanding(countryName, leagueName, teamName);

	    }

   

	

	@ExceptionHandler

	public String handleException( Exception e ) {

		logger.error(e.getMessage());

		return "Invalid input";

	}

}
