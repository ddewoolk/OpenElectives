package ca.ryerson.electives.domain;

public class SubCategory {
	private int subCategoryId;  
	private int categoryId;
	 private String name;  
	 private String description;  
	  
	 public int getSubCategoryId() {  
	  return subCategoryId;  
	 }  
	  
	 public void setSubCategoryId(int subCategoryId) {  
	  this.subCategoryId = subCategoryId;  
	 }  
	  
	 public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
