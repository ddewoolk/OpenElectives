package ca.ryerson.electives.dao;
/** 
 * 
 * @author 
 */  
  
import java.util.List;

import ca.ryerson.electives.domain.Subtheme;
  
public interface SubthemeDao {  
 public List<Subtheme> getSubthemeList();  
 public List<Subtheme> getSubthemesForTheme(int theme);
}  