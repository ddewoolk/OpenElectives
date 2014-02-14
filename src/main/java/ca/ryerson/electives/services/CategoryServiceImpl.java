package ca.ryerson.electives.services;

/** 
 * 
 * @author 
 */  

import java.util.List;  


import org.springframework.beans.factory.annotation.Autowired;  

import ca.ryerson.electives.dao.CategoryDao;  
import ca.ryerson.electives.domain.Category;

public class CategoryServiceImpl implements CategoryService {

	@Autowired  
	CategoryDao categorydao;

	@Override  
	public List<Category> getCategoryList() {  
		return categorydao.getCategoryList();  
	} 

	@Override  
	public List<Category> getCategoriesForTheme(int theme) {  
		return categorydao.getCategoriesForTheme(theme);  
	} 
}
