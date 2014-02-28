package ca.ryerson.electives.dao;
/** 
 * 
 * @author 
 */  
  
import java.util.List;

import ca.ryerson.electives.domain.Semester;

public interface SemesterDao {
 public List<Semester> getSemesterList();
 public List<Semester> getActiveSemesterList();
}  