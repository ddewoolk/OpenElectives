package ca.ryerson.electives.jdbc;

/** 
 * 
 * @author 
 */  
  
  
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import ca.ryerson.electives.domain.Subtheme;
  
public class SubthemeExtractor implements ResultSetExtractor<Subtheme> {  
  
 public Subtheme extractData(ResultSet resultSet) throws SQLException,  
   DataAccessException {  
    
  Subtheme subtheme = new Subtheme();  
    
  subtheme.setSubthemeId(resultSet.getInt(1)); 
  subtheme.setThemeId(resultSet.getInt(2)); 
  subtheme.setName(resultSet.getString(3));  
  subtheme.setDescription(resultSet.getString(4));  
    
  return subtheme;  
 }  
  
}  
