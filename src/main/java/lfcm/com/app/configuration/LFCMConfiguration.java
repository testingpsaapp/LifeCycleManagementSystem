package lfcm.com.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import redis.clients.jedis.Jedis;

@Configuration
public class LFCMConfiguration {
	
	@Autowired
	Environment environment;
	
	@Bean
	public Jedis getJedisConnection()
	{
		Jedis jedis = new Jedis(environment.getProperty("spring.redis.host"),Integer.parseInt(environment.getProperty("spring.redis.port")));
		return jedis;
	}

}
