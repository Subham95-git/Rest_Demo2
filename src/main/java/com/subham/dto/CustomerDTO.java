package com.subham.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class CustomerDTO {

	long phoneNo;
	@NotNull(message = "Name can not be empty")
	String name;
	
	@Email(message = "Email is not in format, please check")
	String email;
	int age;
	char gender;
	List<FriendFamilyDTO> friendFamily;
	String password;
	String address;
	PlanDTO currentPlan;
	
	
	//Getter Setter
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public List<FriendFamilyDTO> getFriendFamily() {
		return friendFamily;
	}
	public void setFriendFamily(List<FriendFamilyDTO> friendFamily) {
		this.friendFamily = friendFamily;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public PlanDTO getCurrentPlan() {
		return currentPlan;
	}
	public void setCurrentPlan(PlanDTO currentPlan) {
		this.currentPlan = currentPlan;
	}
	
	
	@Override
	public String toString() {
		return "CustomerDTO [phoneNo=" + phoneNo + ", name=" + name + ", email=" + email + ", age=" + age + ", gender="
				+ gender + ", friendFamily=" + friendFamily + ", password=" + password + ", address=" + address
				+ ", currentPlan=" + currentPlan + "]";
	}
	
	
}
