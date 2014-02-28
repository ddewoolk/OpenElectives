package ca.ryerson.electives.dao;
/** 
 * 
 * @author 
 */  
  
import java.util.List;  

import ca.ryerson.electives.domain.Course;  
  
public interface CourseDao {  
 public List<Course> getCourseList();  
 public List<Course> getCourseList(int categoryid);
}  