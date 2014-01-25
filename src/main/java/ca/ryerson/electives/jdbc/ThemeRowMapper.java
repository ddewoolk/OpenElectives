package ca.ryerson.electives.jdbc;

/** 
 * 
 * @author 
 */  
  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.jdbc.core.RowMapper;  
import ca.ryerson.electives.domain.Theme;;  
  
public class ThemeRowMapper implements RowMapper<Theme> {  
  
 @Override  
 public Theme mapRow(ResultSet resultSet, int line) throws SQLException {  
  ThemeExtractor themeExtractor = new ThemeExtractor();  
  return themeExtractor.extractData(resultSet);  
 }  
  
}  
