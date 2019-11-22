package com.sapient.football.standing.repositories;



import java.util.Arrays;



import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Repository;

import org.springframework.web.client.RestTemplate;



import com.sapient.football.standing.vo.CountryVO;

import com.sapient.football.standing.vo.TeamVO;



@Repository

public class TeamRepository {



	@Value("${api-host}")

	private String footballApiHost;



	@Value("${api-key}")

	private String apiKey;



	public TeamVO getTeamByName(String teamName, Integer leagueId) {

		RestTemplate restTemplate = new RestTemplate();

		String uri = footballApiHost + "?action=get_teams&league_id=" + leagueId + "&APIkey=" + apiKey;

		TeamVO[] teams = restTemplate.getForObject(uri, TeamVO[].class);

		return Arrays.stream(teams).filter(team -> team.getTeamName().equalsIgnoreCase(teamName)).findFirst().get();

	}



}