package lfcm.com.app.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lfcm.com.app.dao.CacheDao;
import lfcm.com.app.dao.UserRepository;
import lfcm.com.app.entity.CLAAcessConfig;
import lfcm.com.app.entity.SessionData;
import lfcm.com.app.entity.User;
import lfcm.com.app.utilities.EncryptDecrypt;
import lfcm.com.app.utilities.GenerateUUID;


@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CacheDao cacheDao;
	
	@Autowired
	GenerateUUID generateUUID;
	
	@Autowired
	EncryptDecrypt encryptDecrypt;
	
	@Autowired
	CLAAccessConfigService cLAAccessConfigService;
	
	
	public String registerUser(User user)
	{
		String message = "{\"message\":\"Registration Failed\"}";;
		//Step 1 Check if user already present
		User newUser = userRepository.findBySoeId(user.getSoeId());
		if(newUser!=null)
		{
			message = "{\"message\":\"User Already Exists.\"}";
		}
		//Step 2 If not present add user
		else
		{
			try {
				user.setPassword(encryptDecrypt.encrypt(user.getPassword(), user.getSoeId()));
				user.setConfirmPassword(encryptDecrypt.encrypt(user.getConfirmPassword(), user.getSoeId()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			User registerUser = userRepository.saveAndFlush(user);
			if(registerUser!=null)
			{
				message = "{\"message\":\"Registration Successful. Please Login To Proceed.\"}";
			}
		}
		return message;
	}
	
	public List<Object> validateLogin(User user)
	{
		List<Object> listOfLoginObject=null;
		String loginPassword = user.getPassword();
		String storedPassword="";
		User userInDb=null;
		userInDb=userRepository.findBySoeId(user.getSoeId());
		if(userInDb!=null)
		{
			try {
				storedPassword = encryptDecrypt.decrypt(userInDb.getPassword(),userInDb.getSoeId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			listOfLoginObject=new ArrayList<Object>();
			listOfLoginObject.add("{\"status\":\"User Not Registered\"}");
			return listOfLoginObject;
		}
		System.out.println(storedPassword);
		System.out.println(loginPassword);
		
		if(loginPassword.equals(storedPassword))
		{
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			SessionData sessionData= new SessionData();
			sessionData.setLastAccessTime(timestamp);
			userInDb.setUuid(generateUUID.getUUID().toString());
			sessionData.setUser(userInDb);
			System.out.println(sessionData.toString());
			cacheDao.saveSessionData(userInDb.getUuid(), sessionData);
			listOfLoginObject=new ArrayList<Object>();
			listOfLoginObject.add("{\"status\":\"Login Successful\"}");
			listOfLoginObject.add(userInDb);
			//listOfLoginObject.add("Menu Object");
			//Menu Creation Begins Here
			//Step 1 get the role of the user
			CLAAcessConfig cLAAcessConfig = cLAAccessConfigService.getCLAAcessConfigBySoeId(userInDb.getSoeId());
			if(cLAAcessConfig==null)
			{
				listOfLoginObject.add("{\"menu\":\"none\"}");
			}
			else
			{
				//get the main menus 
				//iterate main menu to get submenu
				//iterate submenu to get action and action link
			}
		}
		else
		{
			listOfLoginObject=new ArrayList<Object>();
			listOfLoginObject.add("{\"status\":\"Incorrect Credential\"}");
			return listOfLoginObject;
		}
		
		return listOfLoginObject;
	}
}
