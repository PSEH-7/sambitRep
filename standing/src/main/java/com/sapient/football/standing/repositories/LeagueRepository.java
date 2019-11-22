package com.sapient.football.standing.repositories;

import java.util.Arrays;



import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Repository;

import org.springframework.web.client.RestTemplate;



import com.sapient.football.standing.vo.LeagueVO;



@Repository

public class LeagueRepository {



	@Value("${api-host}")

	private String footballApiHost;

	

	@Value("${api-key}")

	private String apiKey;

	

	public LeagueVO getLeagueByName(String name, Integer countryId) {

		RestTemplate restTemplate = new RestTemplate();

		String uri = footballApiHost+ "?action=get_leagues&country_id="+ countryId+"&APIkey="+apiKey;

		LeagueVO[] leagueList= restTemplate.getForObject(uri, LeagueVO[].class);

	    return Arrays.stream(leagueList).filter(league -> league.getName().equalsIgnoreCase(name)).findFirst().get();

	}

}
