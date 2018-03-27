package lfcm.com.app.entity;

import java.util.List;

public class UserMenu 
{
	private String mainMenu;
	private List<UserSubMenu> subMenu;
	
	public String getMainMenu() {
		return mainMenu;
	}
	public void setMainMenu(String mainMenu) {
		this.mainMenu = mainMenu;
	}
	public List<UserSubMenu> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(List<UserSubMenu> subMenu) {
		this.subMenu = subMenu;
	}
	
	
}
