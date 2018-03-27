package lfcm.com.app.entity;

import java.sql.Timestamp;

public class SessionData {
	
	private User user;
	private Timestamp lastAccessTime;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Timestamp getLastAccessTime() {
		return lastAccessTime;
	}
	public void setLastAccessTime(Timestamp lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}
	
	@Override
	public String toString() {
		return "SessionData [user=" + user.toString() + ", lastAccessTime=" + lastAccessTime + "]";
	}
	
	
}
