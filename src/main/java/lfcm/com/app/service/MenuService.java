package lfcm.com.app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lfcm.com.app.dao.MenuRepository;
import lfcm.com.app.entity.Menu;
import lfcm.com.app.entity.UserMenu;

@Service
public class MenuService {
	
	@Autowired
	MenuRepository menuRepository;

	public UserMenu getUserMenu(String role) {
		UserMenu userMenu = new UserMenu();
		List<String> mainMenuList = menuRepository.getMainMenuNameByAccessGroup(role);
		for(int i=0;i<mainMenuList.size();i++)
		{
			userMenu.setMainMenu(mainMenuList.get(i));
			List<String> subMenuList =menuRepository.getMenuByMainMenu(mainMenuList.get(i),role);
			userMenu.setSubMenuName(subMenuList);
			for(int j=0;j<subMenuList.size();j++)
			{
				
			}
		}
		return userMenu;
	}

}
