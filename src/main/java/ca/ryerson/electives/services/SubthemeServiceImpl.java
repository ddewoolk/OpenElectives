package ca.ryerson.electives.services;

/** 
 * 
 * @author 
 */  

import java.util.List;  


import org.springframework.beans.factory.annotation.Autowired;  

import ca.ryerson.electives.dao.SubthemeDao;  
import ca.ryerson.electives.domain.Subtheme;

public class SubthemeServiceImpl implements SubthemeService {

	@Autowired  
	SubthemeDao subthemedao;

	@Override  
	public List<Subtheme> getSubthemeList() {  
		return subthemedao.getSubthemeList();  
	} 

	@Override  
	public List<Subtheme> getSubthemesForTheme(int theme) {  
		return subthemedao.getSubthemesForTheme(theme);  
	} 
}
