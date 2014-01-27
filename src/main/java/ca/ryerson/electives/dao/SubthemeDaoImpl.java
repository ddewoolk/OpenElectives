package ca.ryerson.electives.dao;

import java.util.List;
import java.util.ArrayList;  

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import ca.ryerson.electives.domain.Subtheme;
import ca.ryerson.electives.jdbc.SubthemeRowMapper;

public class SubthemeDaoImpl implements SubthemeDao {
	
	@Autowired
	public DataSource dataSource;


	public  List<Subtheme> getSubthemeList() {  
	    	  List<Subtheme> subthemeList = new ArrayList<Subtheme>();  
	    	  
	    	  String sql = "SELECT * FROM SUB_THEMES";  
	    	  
	    	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
	    	  subthemeList = jdbcTemplate.query(sql, new SubthemeRowMapper());  
	    	  return subthemeList;  
	    	 }  
	    
	    
	 
}
