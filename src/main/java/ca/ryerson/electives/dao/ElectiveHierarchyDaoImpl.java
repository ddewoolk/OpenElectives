package ca.ryerson.electives.dao;

import java.util.List;
import java.util.ArrayList;  

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import ca.ryerson.electives.domain.Course;
import ca.ryerson.electives.jdbc.CourseRowMapper;

public class ElectiveHierarchyDaoImpl implements ElectiveHierarchyDao {

	@Autowired
	public DataSource dataSource;

	@Override
	public  List<Course> getCourseListFromHierarchy(int themeId, int categoryId, int subcategoryId, String discipline, String prereqs, String antireqs, int semesterId) {  
		List<Course> courseList = new ArrayList<Course>();  
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql;
		Object[] queryVar = new Object[100];
		String formattedPrereqs;
		String formattedAntireqs;

		//Filter by Elective Hierarchy
		if (subcategoryId > 0)
		{
			sql = "SELECT * FROM COURSES WHERE COURSE_ID IN ( SELECT COURSE_ID FROM ELECTIVE_HIERARCHY WHERE SUB_CATEGORY_ID = ?)";  
			queryVar[0] = subcategoryId;
		}
		else if (categoryId > 0) {
			sql = "SELECT * FROM COURSES WHERE COURSE_ID IN (SELECT COURSE_ID FROM ELECTIVE_HIERARCHY WHERE CATEGORY_ID = ?)";  
			queryVar[0] = categoryId;
		}
		else if (themeId > 0){
			sql = "SELECT * FROM COURSES WHERE COURSE_ID IN (SELECT COURSE_ID FROM ELECTIVE_HIERARCHY WHERE THEME_ID = ?)";  
			queryVar[0] = themeId;
		}
		else {
			sql = "select * from COURSES where COURSE_ID IN (SELECT COURSE_ID FROM SEMESTER_OFFERINGS WHERE "
	    	  		+ "SEMESTER_ID IN (SELECT SEMESTER_ID FROM SEMESTERS WHERE IS_ACTIVE = 'Y')) AND 1 = ?";
			queryVar[0] = 1;
		}

		//Filter by Discipline/Subject
		sql += " AND (LOWER(NVL(ACAD_ORG,'%')) LIKE LOWER(?) "
			+  "OR LOWER(NVL(SUBJECT,'%')) LIKE LOWER(?))";
		queryVar[1] = "%" + discipline + "%";
		queryVar[2] = "%" + discipline + "%";

		//Filter by Pre-requisites
		sql += " AND REGEXP_LIKE(NVL(PRE_REQUISITES,'*'),?,'i')";
		formattedPrereqs = prereqs.replace(",","*|*").replace(" ", "\\s");
		queryVar[3] = "*" + formattedPrereqs;	

		//Filter by Anti-requisites
		sql += " AND REGEXP_LIKE(NVL(ANTI_REQUISITES,'*'),?,'i')";
		formattedAntireqs = antireqs.replace(",","*|*").replace(" ", "\\s");
		queryVar[4] = "*" + formattedAntireqs;	
		
		//Filter by Semester
		if (semesterId > 0){
			sql += " AND COURSE_ID IN (SELECT COURSE_ID FROM SEMESTER_OFFERINGS WHERE SEMESTER_ID = ?)";  
			queryVar[5] = semesterId;
		}
		else {
			sql += " AND 1 = ?";
			queryVar[5] = 1;	
		}
			


		courseList = jdbcTemplate.query(sql, new Object [] {queryVar[0],queryVar[1],queryVar[2],queryVar[3],queryVar[4],queryVar[5]},  new CourseRowMapper());
		return courseList;  
	}  



}
