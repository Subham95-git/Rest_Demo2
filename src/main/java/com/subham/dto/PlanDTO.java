package com.subham.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlanDTO {

	Integer planID;
	String planName;
	Integer nationalRate;
	Integer internationalRate;
	
	
	//Getter Setter
	public Integer getPlanID() {
		return planID;
	}
	public void setPlanID(Integer planID) {
		this.planID = planID;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public Integer getNationalRate() {
		return nationalRate;
	}
	public void setNationalRate(Integer nationalRate) {
		this.nationalRate = nationalRate;
	}
	public Integer getInternationalRate() {
		return internationalRate;
	}
	public void setInternationalRate(Integer internationalRate) {
		this.internationalRate = internationalRate;
	}
	
	@Override
	public String toString() {
		return "PlanDTO [planID=" + planID + ", planName=" + planName + ", nationalRate=" + nationalRate
				+ ", internationalRate=" + internationalRate + "]";
	}
	
}
