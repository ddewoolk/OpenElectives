package ca.ryerson.electives.domain;

public class ElectiveHierarchy {

	private int electiveHierarchyId;
	private int themeId;
	private int subthemeId;
	private int categoryId;
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
	
	public int getSubthemeId() {
		return subthemeId;
	}

	public void setSubthemeId(int subthemeId) {
		this.subthemeId = subthemeId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


}
