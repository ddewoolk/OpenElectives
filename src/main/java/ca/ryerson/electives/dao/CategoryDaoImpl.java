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


	public  List<Category> getCategoryList() {  
		List<Category> subthemeList = new ArrayList<Category>();  

		String sql = "SELECT * FROM CATEGORIES";  

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
		subthemeList = jdbcTemplate.query(sql, new CategoryRowMapper());  
		return subthemeList;  
	}  
	
	public  List<Category> getCategoriesForTheme(int theme) {  
		List<Category> subthemeList = new ArrayList<Category>();  

		String sql = "SELECT * FROM CATEGORIES WHERE THEME_ID = ?";  

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
		subthemeList = jdbcTemplate.query(sql, new Object[] {theme},new CategoryRowMapper());  
		return subthemeList;  
	}   


}
