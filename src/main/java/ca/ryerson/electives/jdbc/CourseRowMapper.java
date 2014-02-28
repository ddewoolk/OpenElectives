package ca.ryerson.electives.jdbc;

/** 
 * 
 * @author 
 */  
  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.jdbc.core.RowMapper;  
import ca.ryerson.electives.domain.Course;  
  
public class CourseRowMapper implements RowMapper<Course> {  
  
 @Override  
 public Course mapRow(ResultSet resultSet, int line) throws SQLException {  
  CourseExtractor courseExtractor = new CourseExtractor();  
  return courseExtractor.extractData(resultSet);  
 }  
  
}  
