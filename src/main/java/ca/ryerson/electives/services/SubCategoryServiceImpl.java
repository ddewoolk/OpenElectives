package ca.ryerson.electives.services;

/** 
 * 
 * @author 
 */  
  
import java.util.List;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import ca.ryerson.electives.dao.SubCategoryDao;  
import ca.ryerson.electives.domain.SubCategory; 

public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired  
	 SubCategoryDao subcategoryDao;
	
	@Override  
	 public List<SubCategory> getSubCategoryList() {  
	  return subcategoryDao.getSubCategoryList();  
	 } 
	
	@Override  
	 public List<SubCategory> getSubCategoriesForTheme(int theme) {  
	  return subcategoryDao.getSubCategoriesForTheme(theme);  
	 } 
	
	@Override  
	 public List<SubCategory> getSubCategoriesForCategory(int category) {  
	  return subcategoryDao.getSubCategoriesForCategory(category);  
	 } 

}
