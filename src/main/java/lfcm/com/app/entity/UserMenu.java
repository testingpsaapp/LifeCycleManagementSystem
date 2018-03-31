package lfcm.com.app.entity;

import java.util.ArrayList;
import java.util.List;

public class UserMenu 
{
	private String mainMenu;
	private List<String> subMenuName;
	private List<String> subMenuLink;
	private List<ArrayList<String>> subMenuAction;
	
	public String getMainMenu() {
		return mainMenu;
	}
	public void setMainMenu(String mainMenu) {
		this.mainMenu = mainMenu;
	}
	public List<String> getSubMenuName() {
		return subMenuName;
	}
	public void setSubMenuName(List<String> subMenuName) {
		this.subMenuName = subMenuName;
	}
	public List<String> getSubMenuLink() {
		return subMenuLink;
	}
	public void setSubMenuLink(List<String> subMenuLink) {
		this.subMenuLink = subMenuLink;
	}
	public List<ArrayList<String>> getSubMenuAction() {
		return subMenuAction;
	}
	public void setSubMenuAction(List<ArrayList<String>> subMenuAction) {
		this.subMenuAction = subMenuAction;
	}
	
	
	
	
}
