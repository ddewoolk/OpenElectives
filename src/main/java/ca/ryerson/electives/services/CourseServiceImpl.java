package ca.ryerson.electives.services;

/** 
 * 
 * @author 
 */  
  
import java.util.List;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import ca.ryerson.electives.dao.CourseDao;  
import ca.ryerson.electives.domain.Course;  
public class CourseServiceImpl implements CourseService {

	@Autowired  
	 CourseDao courseDao;
	
	@Override  
	 public List<Course> getCourseList() {  
	  return courseDao.getCourseList();  
	 } 
	
	@Override  
	 public List<Course> getCourseList(int categoryId) {  
	  return courseDao.getCourseList(categoryId);  
	 } 

}
