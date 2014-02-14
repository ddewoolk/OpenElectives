package ca.ryerson.electives.dao;

import java.util.List;
import java.util.ArrayList;  

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import ca.ryerson.electives.domain.SubCategory;  
import ca.ryerson.electives.jdbc.SubCategoryRowMapper;

public class SubCategoryDaoImpl implements SubCategoryDao {
	
	@Autowired
	public DataSource dataSource;

    @Override
	public  List<SubCategory> getSubCategoryList() {  
	    	  List<SubCategory> categoryList = new ArrayList<SubCategory>();  
	    	  
	    	  String sql = "SELECT * FROM SUB_CATEGORIES";  
	    	  
	    	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
	    	  categoryList = jdbcTemplate.query(sql, new SubCategoryRowMapper());  
	    	  return categoryList;  
	    	 }  

    @Override
	public  List<SubCategory> getSubCategoriesForTheme(int theme) {  
	    	  List<SubCategory> categoryList = new ArrayList<SubCategory>();  
	    	  
	    	  String sql = "SELECT * FROM SUB_CATEGORIES WHERE CATEGORY_ID IN ( "
	    	  			+  "SELECT CATEGORY_ID FROM CATEGORIES WHERE THEME_ID = ?)";  
	    	  
	    	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
	    	  categoryList = jdbcTemplate.query(sql,new Object[] {theme}, new SubCategoryRowMapper());  
	    	  return categoryList;  
	    	 } 
    
    @Override
   	public  List<SubCategory> getSubCategoriesForCategory(int category) {  
   	    	  List<SubCategory> categoryList = new ArrayList<SubCategory>();  
   	    	  
   	    	  String sql = "SELECT * FROM SUB_CATEGORIES WHERE CATEGORY_ID = ?";  
   	    	  
   	    	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
   	    	  categoryList = jdbcTemplate.query(sql,new Object[] {category}, new SubCategoryRowMapper());  
   	    	  return categoryList;  
   	    	 } 
	    
	 
}
