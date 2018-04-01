package lfcm.com.app.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lfcm.com.app.dao.MenuRepository;
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
			List<String> subMenuLinkList= new ArrayList<String>();
			List<ArrayList<String>> subMenuActionList = new ArrayList<ArrayList<String>>();
			for(int j=0;j<subMenuList.size();j++)
			{
				String subMenuLink = menuRepository.getSubMenuLinkByMainMenuSubMenuAccess(mainMenuList.get(i),role,subMenuList.get(j));
				subMenuLinkList.add(subMenuLink);
				ArrayList<String> subMenuAction = (ArrayList<String>) menuRepository.getSubMenuAction(mainMenuList.get(i), role, subMenuList.get(j));
				subMenuActionList.add(subMenuAction);
			}
			userMenu.setSubMenuLink(subMenuLinkList);
			userMenu.setSubMenuAction(subMenuActionList);
		}
		return userMenu;
	}

}
