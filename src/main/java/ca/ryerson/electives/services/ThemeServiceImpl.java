package ca.ryerson.electives.services;

/** 
 * 
 * @author 
 */  
  
import java.util.List;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import ca.ryerson.electives.dao.ThemeDao;  
import ca.ryerson.electives.domain.Theme; 

public class ThemeServiceImpl implements ThemeService {

	@Autowired  
	 ThemeDao themedao;
	
	@Override  
	 public List<Theme> getThemeList() {  
	  return themedao.getThemeList();  
	 } 

}
