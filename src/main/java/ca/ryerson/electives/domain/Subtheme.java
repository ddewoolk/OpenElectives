package ca.ryerson.electives.domain;

public class Subtheme {
	private int subthemeId;  
	private int themeId;
	 private String name;  
	 private String description;  
	  
	
	public int getSubthemeId() {
		return subthemeId;
	}

	public void setSubthemeId(int subthemeId) {
		this.subthemeId = subthemeId;
	}

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
