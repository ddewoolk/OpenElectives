package ca.ryerson.electives.dao;
/** 
 * 
 * @author 
 */  
  
import java.util.List;

import ca.ryerson.electives.domain.Category;
  
public interface CategoryDao {  
 public List<Category> getCategoryList();  
 public List<Category> getCategoriesForTheme(int theme); 
 public List<Category> getCategoriesForSubtheme(int subtheme); 
}  