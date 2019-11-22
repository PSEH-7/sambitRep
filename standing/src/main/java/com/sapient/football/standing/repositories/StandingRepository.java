package com.sapient.football.standing.repositories;



import java.util.Arrays;




import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Repository;

import org.springframework.web.client.RestTemplate;



import com.sapient.football.standing.vo.StandingVO;



@Repository

public class StandingRepository {

	@Value("${api-host}")

	private String footballApiHost;

	

	@Value("${api-key}")

	private String apiKey;

	

	public StandingVO getStanding(Integer leagueId, Integer teamId){

		RestTemplate restTemplate = new RestTemplate();

		String uri = footballApiHost+ "?action=get_standings&league_id="+ leagueId+ "&APIkey="+apiKey;

		StandingVO[] standings = restTemplate.getForObject(uri, StandingVO[].class);

        return Arrays.stream(standings).filter(standing -> standing.getTeamId().equals(teamId)).findFirst().get();

	}

}