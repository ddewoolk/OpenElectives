package ca.ryerson.electives.services;

/** 
 * 
 * @author  
 */  
  
import java.util.List;  
import ca.ryerson.electives.domain.SubCategory;  
  
public interface SubCategoryService {  
  
 public List<SubCategory> getSubCategoryList();  
 public List<SubCategory> getSubCategoriesForTheme(int theme); 
 public List<SubCategory> getSubCategoriesForCategory(int category);
} 