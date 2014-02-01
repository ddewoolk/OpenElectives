package ca.ryerson.electives.dao;

import java.util.List;
import java.util.ArrayList;  

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import ca.ryerson.electives.domain.Category;  
import ca.ryerson.electives.jdbc.CategoryRowMapper;

public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	public DataSource dataSource;

    @Override
	public  List<Category> getCategoryList() {  
	    	  List<Category> categoryList = new ArrayList<Category>();  
	    	  
	    	  String sql = "SELECT * FROM CATEGORIES";  
	    	  
	    	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
	    	  categoryList = jdbcTemplate.query(sql, new CategoryRowMapper());  
	    	  return categoryList;  
	    	 }  

    @Override
	public  List<Category> getCategoriesForTheme(int theme) {  
	    	  List<Category> categoryList = new ArrayList<Category>();  
	    	  
	    	  String sql = "SELECT * FROM CATEGORIES WHERE SUB_THEME_ID IN ( "
	    	  			+  "SELECT SUB_THEME_ID FROM SUB_THEMES WHERE THEME_ID = ?)";  
	    	  
	    	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
	    	  categoryList = jdbcTemplate.query(sql,new Object[] {theme}, new CategoryRowMapper());  
	    	  return categoryList;  
	    	 } 
    
    @Override
   	public  List<Category> getCategoriesForSubtheme(int subtheme) {  
   	    	  List<Category> categoryList = new ArrayList<Category>();  
   	    	  
   	    	  String sql = "SELECT * FROM CATEGORIES WHERE SUB_THEME_ID = ?";  
   	    	  
   	    	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
   	    	  categoryList = jdbcTemplate.query(sql,new Object[] {subtheme}, new CategoryRowMapper());  
   	    	  return categoryList;  
   	    	 } 
	    
	 
}
