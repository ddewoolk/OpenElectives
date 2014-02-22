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
  course.setSubject(resultSet.getString(2));  
  course.setCatalogNbr(resultSet.getString(3)); 
  course.setCourseTitle(resultSet.getString(4));
  course.setAcadGroup(resultSet.getString(5));
  course.setAcadOrg(resultSet.getString(6));
  course.setCalendarDescription(resultSet.getString(7));
  course.setPrerequisites(resultSet.getString(8));
  course.setAntirequisites(resultSet.getString(9));
  
    
  return course;  
 }  
  
}  

