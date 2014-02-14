package ca.ryerson.electives.jdbc;

/** 
 * 
 * @author 
 */  
  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.jdbc.core.RowMapper;  
import ca.ryerson.electives.domain.SubCategory;;  
  
public class SubCategoryRowMapper implements RowMapper<SubCategory> {  
  
 @Override  
 public SubCategory mapRow(ResultSet resultSet, int line) throws SQLException {  
  SubCategoryExtractor subCategoryExtractor = new SubCategoryExtractor();  
  return subCategoryExtractor.extractData(resultSet);  
 }  
  
}  
