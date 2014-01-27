package ca.ryerson.electives.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ca.ryerson.electives.domain.Category;
import ca.ryerson.electives.domain.Course;
import ca.ryerson.electives.domain.Subtheme;
import ca.ryerson.electives.domain.Theme;
import ca.ryerson.electives.services.CategoryService;
import ca.ryerson.electives.services.CourseService;
import ca.ryerson.electives.services.SubthemeService;
import ca.ryerson.electives.services.ThemeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired  
	 CourseService courseService;
	@Autowired
     CategoryService categoryService;
	@Autowired
	 ThemeService themeService;
	@Autowired
	 SubthemeService subthemeService;
     
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	 @RequestMapping(value= "/getCourseList",method = RequestMethod.GET)  
	 public String getCourseList(@RequestParam(value = "category", required = false, defaultValue = "0") int category,Locale locale, Model model) {  
		 
		 List<Course> courseList;
		 
//		 if (category > 0)
//		 {
//			 courseList = courseService.getCourseList(category);  
//		 }
//		 else 
//		 {
			 courseList = courseService.getCourseList();  
//		 }
//	  
	  List<Category> categoryList = categoryService.getCategoryList();
	  List<Theme> themeList = themeService.getThemeList();
	  List<Subtheme> subthemeList = subthemeService.getSubthemeList();

	  model.addAttribute("categoryList",categoryList);
	  model.addAttribute("courseList",courseList);
	  model.addAttribute("themeList",themeList);
	  model.addAttribute("subthemeList",subthemeList);

	  return "courseList";
	 }  
	 
}
