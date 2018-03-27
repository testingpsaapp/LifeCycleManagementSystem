package lfcm.com.app.entity;


import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="user")
public class User 
{
	
	
	private long id;
	private String soeId;
	private String firstName;
	private String lastName;
	private String[] region;
	private String lob;
	private String[] applications;
	private String userType;
	private String country;
	private String department;
	private String password;
	private String confirmPassword;
	
	@Transient
	private String uuid;
	
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSoeId() {
		return soeId;
	}
	public void setSoeId(String soeId) {
		this.soeId = soeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String[] getRegion() {
		return region;
	}
	public void setRegion(String[] region) {
		this.region = region;
	}
	public String getLob() {
		return lob;
	}
	public void setLob(String lob) {
		this.lob = lob;
	}
	public String[] getApplications() {
		return applications;
	}
	public void setApplications(String[] applications) {
		this.applications = applications;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", soeId=" + soeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", region=" + Arrays.toString(region) + ", lob=" + lob + ", applications="
				+ Arrays.toString(applications) + ", userType=" + userType + ", country=" + country + ", department="
				+ department + ", password=" + password + ", confirmPassword=" + confirmPassword + ", uuid=" + uuid
				+ "]";
	}
	
	
	
}
