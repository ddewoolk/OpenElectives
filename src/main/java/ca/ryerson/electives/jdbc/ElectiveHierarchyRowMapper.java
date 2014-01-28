package ca.ryerson.electives.jdbc;

/** 
 * 
 * @author 
 */  
  
import java.sql.ResultSet;  
import java.sql.SQLException;  

import org.springframework.jdbc.core.RowMapper;
import ca.ryerson.electives.domain.ElectiveHierarchy;

public class ElectiveHierarchyRowMapper implements RowMapper<ElectiveHierarchy> {  
  
 @Override  
 public ElectiveHierarchy mapRow(ResultSet resultSet, int line) throws SQLException {  
  ElectiveHierarchyExtractor electiveHierarchyExtractor = new ElectiveHierarchyExtractor();  
  return electiveHierarchyExtractor.extractData(resultSet);  
 }  
  
}  
