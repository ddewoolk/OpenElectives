package ca.ryerson.electives.jdbc;

/** 
 * 
 * @author 
 */  
  
  
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import ca.ryerson.electives.domain.Category;
  
public class CategoryExtractor implements ResultSetExtractor<Category> {  
  
 public Category extractData(ResultSet resultSet) throws SQLException,  
   DataAccessException {  
    
  Category category = new Category();  
    
  category.setCategoryId(resultSet.getInt(1));  
  category.setName(resultSet.getString(2));  
  category.setDescription(resultSet.getString(3));  
    
  return category;  
 }  
  
}  
