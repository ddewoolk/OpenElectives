package ca.ryerson.electives.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import ca.ryerson.electives.domain.Course;
import ca.ryerson.electives.jdbc.CourseRowMapper;

public class CourseDaoImpl implements CourseDao {
	
	@Autowired
	public DataSource dataSource;

    @Override
	public  List<Course> getCourseList() {  
	    	  List<Course> courseList = new ArrayList<Course>();  
	    	  
	    	  String sql = "select * from COURSES where COURSE_ID IN (SELECT COURSE_ID FROM SEMESTER_OFFERINGS WHERE "
	    	  		+ "SEMESTER_ID IN (SELECT SEMESTER_ID FROM SEMESTERS WHERE IS_ACTIVE = 'Y'))";  
	    	  
	    	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
	    	  courseList = jdbcTemplate.query(sql, new CourseRowMapper());  
	    	  return courseList;  
	    	 }  
    
    @Override
	public  List<Course> getCourseList(int categoryId) {  
  	  List<Course> courseList = new ArrayList<Course>();  
  	  
  	  String sql = "select * from COURSES where categoryId = ?";  
  	  
  	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
  	  courseList = jdbcTemplate.query(sql, new Object [] {categoryId}, new CourseRowMapper());  
  	  return courseList;  
  	 }      
	  
	 
}
