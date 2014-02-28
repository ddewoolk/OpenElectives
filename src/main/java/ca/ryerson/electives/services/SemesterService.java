package ca.ryerson.electives.services;

/** 
 * 
 * @author  
 */  
  
import java.util.List;  

import ca.ryerson.electives.domain.Semester;  
  
public interface SemesterService {  
  
 public List<Semester> getSemesterList(); 
 public List<Semester> getActiveSemesterList(); 
} 