package com.sapient.football.standing.services;

import com.sapient.football.standing.vo.StandingVO;

import org.springframework.beans.factory.annotation.Autowired;

import com.sapient.football.standing.repositories.*;

public class StandingService {

	@Autowired
	StandingRepository standingRepository;	
	@Autowired
	CountryRepository countryRepository;	
	@Autowired
	TeamRepository teamRepository;	

	public StandingVO getStanding(String countryName, String leagueName, String teamName) {
		Integer countryId = countryRepository.getCountryByName(countryName).getId();

		Integer teamId = teamRepository.getTeamByName(teamName, 148).getTeamId();

		StandingVO standing = standingRepository.getStanding(148, teamId);

		standing.setCountryId(countryId);

		return standing;
	}

}
