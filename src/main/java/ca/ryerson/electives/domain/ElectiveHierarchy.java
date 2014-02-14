package ca.ryerson.electives.domain;

public class ElectiveHierarchy {

	private int electiveHierarchyId;
	private int themeId;
	private int categoryId;
	private int subCategoryId;
	private int courseId;

	public int getElectiveHierarchyId() {
		return electiveHierarchyId;
	}

	public void setElectiveHierarchyId(int electiveHierarchyId) {
		this.electiveHierarchyId = electiveHierarchyId;
	}

	public int getThemeId() {
		return themeId;
	}

	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int categoryId) {
		this.subCategoryId = categoryId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


}
