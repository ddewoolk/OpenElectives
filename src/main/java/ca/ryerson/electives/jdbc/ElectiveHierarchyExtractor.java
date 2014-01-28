package ca.ryerson.electives.jdbc;

/** 
 * 
 * @author 
 */  
  
  
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import ca.ryerson.electives.domain.ElectiveHierarchy;
  
public class ElectiveHierarchyExtractor implements ResultSetExtractor<ElectiveHierarchy> {  
  
 public ElectiveHierarchy extractData(ResultSet resultSet) throws SQLException,  
   DataAccessException {  
    
  ElectiveHierarchy electiveHierarchy = new ElectiveHierarchy();  
    
  electiveHierarchy.setElectiveHierarchyId(resultSet.getInt(1)); 
  electiveHierarchy.setThemeId(resultSet.getInt(2)); 
  electiveHierarchy.setSubthemeId(resultSet.getInt(3));
  electiveHierarchy.setCategoryId(resultSet.getInt(4));
  electiveHierarchy.setCourseId(resultSet.getInt(5));
  
  return electiveHierarchy;  
 }  
  
}  
