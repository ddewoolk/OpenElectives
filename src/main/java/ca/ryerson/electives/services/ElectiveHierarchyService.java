package ca.ryerson.electives.services;

/** 
 * 
 * @author  
 */  
  
import java.util.List;  
import ca.ryerson.electives.domain.Course;  
  
public interface ElectiveHierarchyService {  
  
 public List<Course> getCourseListFromHierarchy(int themeId, int subthemeId, int categoryId);  
  
} 