package ca.ryerson.electives.jdbc;

/** 
 * 
 * @author 
 */  
  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.jdbc.core.RowMapper;  
import ca.ryerson.electives.domain.Category;;  
  
public class CategoryRowMapper implements RowMapper<Category> {  
  
 @Override  
 public Category mapRow(ResultSet resultSet, int line) throws SQLException {  
  CategoryExtractor userExtractor = new CategoryExtractor();  
  return userExtractor.extractData(resultSet);  
 }  
  
}  
