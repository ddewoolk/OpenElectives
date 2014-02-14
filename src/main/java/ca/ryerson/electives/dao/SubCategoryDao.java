package ca.ryerson.electives.dao;
/** 
 * 
 * @author 
 */  
  
import java.util.List;

import ca.ryerson.electives.domain.SubCategory;
  
public interface SubCategoryDao {  
 public List<SubCategory> getSubCategoryList();  
 public List<SubCategory> getSubCategoriesForTheme(int theme); 
 public List<SubCategory> getSubCategoriesForCategory(int category); 
}  