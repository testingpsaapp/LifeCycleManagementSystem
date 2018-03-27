package lfcm.com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lfcm.com.app.dao.CountryRepository;
import lfcm.com.app.entity.Countries;



@Service
public class CountryService {
	
	@Autowired
	CountryRepository countryRepository;
	
	public List<Countries> getAllCountry()
	{
		List<Countries> allCountry = countryRepository.findAll();
		return allCountry;
	}
	
	public List<Countries> saveCountry(Countries country)
	{
		countryRepository.saveAndFlush(country);		
		List<Countries> allCountry = countryRepository.findAll();
		return allCountry;
	}

	public List<Countries> getAllCountryRegion(String region) {
		// TODO Auto-generated method stub
		List<Countries> allCountry=null;
		allCountry = countryRepository.findAllByRegion(region);
		return allCountry;
		
	}

	public String saveCountryConfig(Countries country) {
		// TODO Auto-generated method stub
		Countries newCountry = null;
		String result= "{\"message\":\"Country Configuration Save Failed\"}";
		newCountry = countryRepository.saveAndFlush(country);
		if(newCountry!=null)
		{
			result= "{\"message\":\"Country Configuration Saved Successfully\"}";
		}
		return result;
	}


}
