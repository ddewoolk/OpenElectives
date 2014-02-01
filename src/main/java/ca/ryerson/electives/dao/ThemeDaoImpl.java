package ca.ryerson.electives.dao;

import java.util.List;
import java.util.ArrayList;  

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import ca.ryerson.electives.domain.Theme;  
import ca.ryerson.electives.jdbc.ThemeRowMapper;

public class ThemeDaoImpl implements ThemeDao {
	
	@Autowired
	public DataSource dataSource;

	@Override
	public  List<Theme> getThemeList() {  
	    	  List<Theme> themeList = new ArrayList<Theme>();  
	    	  
	    	  String sql = "SELECT * FROM THEMES";  
	    	  
	    	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
	    	  themeList = jdbcTemplate.query(sql, new ThemeRowMapper());  
	    	  return themeList;  
	    	 }  
	    
	    
	 
}
