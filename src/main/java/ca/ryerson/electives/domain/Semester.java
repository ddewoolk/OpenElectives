package ca.ryerson.electives.domain;

public class Semester {
	private int semesterId;  
	 private String name;  
	 private String description;  
	 private String isActive;
	  
	
	public int getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}

	public String getName() {  
	  return name;  
	 }  
	  
	 public void setName(String name) {  
	  this.name = name;  
	 }  
	  
	 public String getDescription() {  
	  return description;  
	 }  
	  
	 public void setDescription(String description) {  
	  this.description = description;  
	 }

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}  
	  
}
