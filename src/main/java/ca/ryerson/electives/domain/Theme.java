package ca.ryerson.electives.domain;

public class Theme {
	private int themeId;  
	 private String name;  
	 private String description;  
	  
	
	public int getThemeId() {
		return themeId;
	}

	public void setThemeId(int themeId) {
		this.themeId = themeId;
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
	  
}
