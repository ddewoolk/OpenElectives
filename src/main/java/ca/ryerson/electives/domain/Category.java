package ca.ryerson.electives.domain;

public class Category {
	private int categoryId;  
	private int subThemeId;
	 private String name;  
	 private String description;  
	  
	 public int getCategoryId() {  
	  return categoryId;  
	 }  
	  
	 public void setCategoryId(int categoryId) {  
	  this.categoryId = categoryId;  
	 }  
	  
	 public int getSubThemeId() {
		return subThemeId;
	}

	public void setSubThemeId(int subThemeId) {
		this.subThemeId = subThemeId;
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
