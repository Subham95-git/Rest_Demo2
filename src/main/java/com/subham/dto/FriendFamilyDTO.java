package com.subham.dto;

public class FriendFamilyDTO {

	long phoneNo;
	long friendandFamily;
	
	//Constructors
	public FriendFamilyDTO() {
		super();
	}
	
	public FriendFamilyDTO(long phoneNo, long friendandFamily) {
		super();
		this.phoneNo = phoneNo;
		this.friendandFamily = friendandFamily;
	}



	//Getter Setter
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public long getFriendandFamily() {
		return friendandFamily;
	}
	public void setFriendandFamily(long friendandFamily) {
		this.friendandFamily = friendandFamily;
	}
	
	@Override
	public String toString() {
		return "FriendFamilyDTO [phoneNo=" + phoneNo + ", friendandFamily=" + friendandFamily + "]";
	}
	
	
}
