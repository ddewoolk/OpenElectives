package ca.ryerson.electives.domain;

public class Course {
	private int courseId; 
	private String subject;
	private String catalogNbr;
	private String courseTitle;
	private String acadGroup;
	private String acadOrg;
	private String calendarDescription; 
	private String prerequisites;
	private String antirequisites;


	public int getCourseId() {  
		return courseId;  
	}  

	public void setCourseId(int courseId) {  
		this.courseId = courseId;  
	}  
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	} 
	
	public String getCatalogNbr() {
		return catalogNbr;
	}

	public void setCatalogNbr(String catalogNbr) {
		this.catalogNbr = catalogNbr;
	}

	public String getCourseTitle() {  
		return courseTitle;  
	}  

	public void setCourseTitle(String courseTitle) {  
		this.courseTitle = courseTitle;  
	}  

	public String getAcadGroup() {
		return acadGroup;
	}

	public void setAcadGroup(String acadGroup) {
		this.acadGroup = acadGroup;
	}

	public String getAcadOrg() {
		return acadOrg;
	}

	public void setAcadOrg(String acadOrg) {
		this.acadOrg = acadOrg;
	}

	public String getCalendarDescription() {
		return calendarDescription;
	}

	public void setCalendarDescription(String calendarDescription) {
		this.calendarDescription = calendarDescription;
	}

	public String getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}

	public String getAntirequisites() {
		return antirequisites;
	}

	public void setAntirequisites(String antirequisites) {
		this.antirequisites = antirequisites;
	}

	

 

}
