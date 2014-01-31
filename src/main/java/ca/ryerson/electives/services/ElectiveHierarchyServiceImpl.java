package ca.ryerson.electives.services;

/** 
 * 
 * @author 
 */  
  
import java.util.List;  
  

import org.springframework.beans.factory.annotation.Autowired;  

import ca.ryerson.electives.dao.ElectiveHierarchyDao;
import ca.ryerson.electives.domain.Course;  

public class ElectiveHierarchyServiceImpl implements ElectiveHierarchyService {

	@Autowired  
	 ElectiveHierarchyDao electiveHierarchyDao;
	
	
	@Override  
	 public List<Course> getCourseListFromHierarchy(int themeId, int subthemeId, int categoryId,String discipline, String prereqs, String antireqs) {  
	  return electiveHierarchyDao.getCourseListFromHierarchy(themeId, subthemeId, categoryId,discipline,prereqs, antireqs);  
	 } 

}
