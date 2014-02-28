package ca.ryerson.electives.dao;

import java.util.List;
import java.util.ArrayList;  

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import ca.ryerson.electives.domain.Semester;  
import ca.ryerson.electives.jdbc.SemesterRowMapper;

public class SemesterDaoImpl implements SemesterDao {
	
	@Autowired
	public DataSource dataSource;
	
	@Override
	public  List<Semester> getSemesterList() {  
  	  List<Semester> semesterList = new ArrayList<Semester>();  
  	  
  	  String sql = "SELECT * FROM SEMESTERS";  
  	  
  	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
  	  semesterList = jdbcTemplate.query(sql, new SemesterRowMapper());  
  	  return semesterList;  
  	 }  

	@Override
	public  List<Semester> getActiveSemesterList() {  
  	  List<Semester> semesterList = new ArrayList<Semester>();  
  	  
  	  String sql = "SELECT * FROM SEMESTERS WHERE IS_ACTIVE = ?";  
  	  
  	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
  	  semesterList = jdbcTemplate.query(sql, new Object[] {"Y"}, new SemesterRowMapper());  
  	  return semesterList;  
  	 }  
	 
}
