package lfcm.com.app.entity;

import java.util.List;

public class UserSubMenu 
{
	private String subMenuName;
	private String subMenuLink;
	private List<String> subMenuAction;
	private List<String> subMenuActionLink;
	
	public String getSubMenuName() {
		return subMenuName;
	}
	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}
	public String getSubMenuLink() {
		return subMenuLink;
	}
	public void setSubMenuLink(String subMenuLink) {
		this.subMenuLink = subMenuLink;
	}
	public List<String> getSubMenuAction() {
		return subMenuAction;
	}
	public void setSubMenuAction(List<String> subMenuAction) {
		this.subMenuAction = subMenuAction;
	}
	public List<String> getSubMenuActionLink() {
		return subMenuActionLink;
	}
	public void setSubMenuActionLink(List<String> subMenuActionLink) {
		this.subMenuActionLink = subMenuActionLink;
	}
	
	
}
