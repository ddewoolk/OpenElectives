package ca.ryerson.electives.jdbc;

/** 
 * 
 * @author 
 */  
  
  
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import ca.ryerson.electives.domain.Semester;
  
public class SemesterExtractor implements ResultSetExtractor<Semester> {  
  
 public Semester extractData(ResultSet resultSet) throws SQLException,  
   DataAccessException {  
    
  Semester semester = new Semester();  
    
  semester.setSemesterId(resultSet.getInt(1)); 
  semester.setName(resultSet.getString(2));  
  semester.setDescription(resultSet.getString(3));  
  semester.setIsActive(resultSet.getString(4));
    
  return semester;  
 }  
  
}  
