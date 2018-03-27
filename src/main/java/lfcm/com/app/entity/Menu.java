package lfcm.com.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu 
{
	private long id;
	private String mainMenu;
	private String subMenu;
	private String subMenuLink;
	private String action;
	private String actionLink;
	private String accessGroup;
	
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMainMenu() {
		return mainMenu;
	}
	public void setMainMenu(String mainMenu) {
		this.mainMenu = mainMenu;
	}
	public String getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(String subMenu) {
		this.subMenu = subMenu;
	}
	public String getSubMenuLink() {
		return subMenuLink;
	}
	public void setSubMenuLink(String subMenuLink) {
		this.subMenuLink = subMenuLink;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getActionLink() {
		return actionLink;
	}
	public void setActionLink(String actionLink) {
		this.actionLink = actionLink;
	}
	public String getAccessGroup() {
		return accessGroup;
	}
	public void setAccessGroup(String accessGroup) {
		this.accessGroup = accessGroup;
	}
	
	
}
