package ca.ryerson.electives.jdbc;

/** 
 * 
 * @author 
 */  
  
  
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import ca.ryerson.electives.domain.SubCategory;
  
public class SubCategoryExtractor implements ResultSetExtractor<SubCategory> {  
  
 public SubCategory extractData(ResultSet resultSet) throws SQLException,  
   DataAccessException {  
    
  SubCategory subcategory = new SubCategory();  
    
  subcategory.setSubCategoryId(resultSet.getInt(1)); 
  subcategory.setCategoryId(resultSet.getInt(2));
  subcategory.setName(resultSet.getString(3));  
  subcategory.setDescription(resultSet.getString(4));  
    
  return subcategory;  
 }  
  
}  
