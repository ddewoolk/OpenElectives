package ca.ryerson.electives.services;

/** 
 * 
 * @author  
 */  
  
import java.util.List;  
import ca.ryerson.electives.domain.Category;  
  
public interface CategoryService {  
  
 public List<Category> getCategoryList();  
 public List<Category> getCategoriesForTheme(int theme); 
 public List<Category> getCategoriesForSubtheme(int subtheme);
} 