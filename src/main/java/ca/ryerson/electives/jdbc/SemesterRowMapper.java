package ca.ryerson.electives.jdbc;

/** 
 * 
 * @author 
 */  
  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.jdbc.core.RowMapper;  
import ca.ryerson.electives.domain.Semester;;  
  
public class SemesterRowMapper implements RowMapper<Semester> {  
  
 @Override  
 public Semester mapRow(ResultSet resultSet, int line) throws SQLException {  
  SemesterExtractor semesterExtractor = new SemesterExtractor();  
  return semesterExtractor.extractData(resultSet);  
 }  
  
}  
