package ca.ryerson.electives.jdbc;

/** 
 * 
 * @author 
 */  
  
  
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import ca.ryerson.electives.domain.Theme;
  
public class ThemeExtractor implements ResultSetExtractor<Theme> {  
  
 public Theme extractData(ResultSet resultSet) throws SQLException,  
   DataAccessException {  
    
  Theme theme = new Theme();  
    
  theme.setThemeId(resultSet.getInt(1)); 
  theme.setName(resultSet.getString(2));  
  theme.setDescription(resultSet.getString(3));  
    
  return theme;  
 }  
  
}  
