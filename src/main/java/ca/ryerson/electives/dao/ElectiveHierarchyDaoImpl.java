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


	public  List<Course> getCourseListFromHierarchy(int themeId, int subthemeId, int categoryId) {  
		List<Course> courseList = new ArrayList<Course>();  

		if (categoryId > 0)
		{
			String sql = "SELECT * FROM COURSES WHERE COURSE_ID IN ( SELECT COURSE_ID FROM ELECTIVE_HIERARCHY WHERE CATEGORY_ID = ?)";  

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
			courseList = jdbcTemplate.query(sql, new Object [] {categoryId},  new CourseRowMapper());   
		}
		else if (subthemeId > 0) {
			String sql = "SELECT * FROM COURSES WHERE COURSE_ID IN (SELECT COURSE_ID FROM ELECTIVE_HIERARCHY WHERE SUB_THEME_ID = ?)";  

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
			courseList = jdbcTemplate.query(sql, new Object [] {subthemeId},  new CourseRowMapper());
		}
		else {

			String sql = "SELECT * FROM COURSES WHERE COURSE_ID IN (SELECT COURSE_ID FROM ELECTIVE_HIERARCHY WHERE THEME_ID = ?)";  

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
			courseList = jdbcTemplate.query(sql, new Object [] {themeId},  new CourseRowMapper());

		}

		return courseList;  
	}  



}
