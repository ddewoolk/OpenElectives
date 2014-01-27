package ca.ryerson.electives.jdbc;

/** 
 * 
 * @author 
 */  
  
import java.sql.ResultSet;  
import java.sql.SQLException;  

import org.springframework.jdbc.core.RowMapper;
import ca.ryerson.electives.domain.Subtheme;

public class SubthemeRowMapper implements RowMapper<Subtheme> {  
  
 @Override  
 public Subtheme mapRow(ResultSet resultSet, int line) throws SQLException {  
  SubthemeExtractor subthemeExtractor = new SubthemeExtractor();  
  return subthemeExtractor.extractData(resultSet);  
 }  
  
}  
