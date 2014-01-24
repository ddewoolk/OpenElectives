package ca.ryerson.electives.services;

/** 
 * 
 * @author  
 */  
  
import java.util.List;  
import ca.ryerson.electives.domain.Course;  
  
public interface CourseService {  
  
 public List<Course> getCourseList();

List<Course> getCourseList(int categoryId);  
  
} 