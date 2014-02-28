package ca.ryerson.electives.dao;
/** 
 * 
 * @author 
 */  
  
import java.util.List;

import ca.ryerson.electives.domain.Course;
  
public interface ElectiveHierarchyDao {  
 public List<Course> getCourseListFromHierarchy(int themeId, int subthemeId, int categoryId, String discipline, String prereqs, String antireqs, int semesterId);  
}  