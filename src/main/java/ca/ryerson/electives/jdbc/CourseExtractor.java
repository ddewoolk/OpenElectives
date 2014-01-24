package ca.ryerson.electives.jdbc;

/** 
 * 
 * @author 
 */  
  
  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.ResultSetExtractor;  
import ca.ryerson.electives.domain.Course;  
  
public class CourseExtractor implements ResultSetExtractor<Course> {  
  
 public Course extractData(ResultSet resultSet) throws SQLException,  
   DataAccessException {  
    
  Course course = new Course();  
    
  course.setCourseId(resultSet.getInt(1));  
  course.setName(resultSet.getString(2));  
  course.setDescription(resultSet.getString(3)); 
  course.setCategoryId(resultSet.getInt(4));
    
  return course;  
 }  
  
}  
