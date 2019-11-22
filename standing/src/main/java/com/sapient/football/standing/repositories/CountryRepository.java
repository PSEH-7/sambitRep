package com.sapient.football.standing.repositories;

import java.util.Arrays;



import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Repository;

import org.springframework.web.client.RestTemplate;



import com.sapient.football.standing.vo.CountryVO;



@Repository

public class CountryRepository {

	

	@Value("${api-host}")

	private String footballApiHost;

	

	@Value("${api-key}")

	private String apiKey;

	

	public CountryVO getCountryByName(String name) {

		RestTemplate restTemplate = new RestTemplate();

		String uri = footballApiHost+ "?action=get_countries&APIkey="+apiKey;

	    CountryVO[] countryList= restTemplate.getForObject(uri, CountryVO[].class);

	    return Arrays.stream(countryList).filter(coutnry -> coutnry.getName().equalsIgnoreCase(name)).findFirst().get();

	}

	



}
