package lfcm.com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import lfcm.com.app.entity.AppConfig;
import lfcm.com.app.entity.Countries;
import lfcm.com.app.entity.User;
import lfcm.com.app.service.AppConfigService;
import lfcm.com.app.service.AuthenticationService;
import lfcm.com.app.service.CountryService;
import lfcm.com.app.service.UserService;



@RestController
public class LifeCycleManagementSystemController 
{
	@Autowired
	UserService userService;
	
	@Autowired
	AuthenticationService authenticationService;
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	AppConfigService appConfigService;
	
	
	/*
	 * User Login Authentication Start Here
	 * */
	
	@RequestMapping(path="/loginAuthenticate", method = RequestMethod.POST)
	public List<Object> loginAuthenticate(@RequestBody User user)
	{
		List<Object> listOfLoginObject = null;
		
		listOfLoginObject=userService.validateLogin(user);
		
		return listOfLoginObject;
	}
	
	
	/*
	 * User registration starts here
	 * */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registration(@RequestBody User user) {
		String message = "{\"message\":\"Registration Failed\"}";
		System.out.println("User Received:" +user.getSoeId());
		message=userService.registerUser(user);
        return message;
    }
	
	/*
	 * Country Service Starts Here
	 * */
	@RequestMapping(path="/countries/{region}", method = RequestMethod.GET)
	public List<Countries> getAllCountriesByRegion(@PathVariable String region)
	{
		return countryService.getAllCountryRegion(region);
	}
	
	/*
	 * AppConfig Service Starts Here
	 * */
	@RequestMapping(path="/appConfig/{lob}", method = RequestMethod.GET)
	public List<AppConfig> getAppConfigByLob(@PathVariable String lob)
	{
		List<AppConfig> listOfAppConfig= null;
		listOfAppConfig = appConfigService.getAppConfigByLobName(lob);
		return listOfAppConfig;
	}
}
