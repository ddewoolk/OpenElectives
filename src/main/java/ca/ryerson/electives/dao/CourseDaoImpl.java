package ca.ryerson.electives.dao;

import java.util.List;
import java.util.ArrayList;  

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import ca.ryerson.electives.domain.Course;  
import ca.ryerson.electives.jdbc.CourseRowMapper;

public class CourseDaoImpl implements CourseDao {
	
	@Autowired
	public DataSource dataSource;


	public  List<Course> getCourseList() {  
	    	  List<Course> courseList = new ArrayList<Course>();  
	    	  
	    	  String sql = "select * from COURSES";  
	    	  
	    	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
	    	  courseList = jdbcTemplate.query(sql, new CourseRowMapper());  
	    	  return courseList;  
	    	 }  
	
	public  List<Course> getCourseList(int categoryId) {  
  	  List<Course> courseList = new ArrayList<Course>();  
  	  
  	  String sql = "select * from COURSE where categoryId = ?";  
  	  
  	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
  	  courseList = jdbcTemplate.query(sql, new Object [] {categoryId}, new CourseRowMapper());  
  	  return courseList;  
  	 }      
	    
	 
}
