package lfcm.com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lfcm.com.app.configuration.LFCMConfiguration;
import lfcm.com.app.entity.SessionData;



@Repository
public class CacheDao 
{
	@Autowired
	LFCMConfiguration lFCMConfiguration;
	
	public void saveSessionData(String key, SessionData sessionData)
	{
		lFCMConfiguration.getJedisConnection().set(key, sessionData.toString());
		System.out.println(lFCMConfiguration.getJedisConnection().get(key));
	}
	
	public void getSessionData(String key)
	{
		lFCMConfiguration.getJedisConnection().get(key);
	}
	
	public void deleteSessionData(String key)
	{
		lFCMConfiguration.getJedisConnection().del(key);
	}
}
