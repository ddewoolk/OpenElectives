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
	 CourseDao coursedao;
	
	@Override  
	 public List<Course> getCourseList() {  
	  return coursedao.getCourseList();  
	 } 
	
	@Override  
	 public List<Course> getCourseList(int categoryId) {  
	  return coursedao.getCourseList(categoryId);  
	 } 

}
