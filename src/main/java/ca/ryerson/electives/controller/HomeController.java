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
import org.springframework.web.bind.annotation.ResponseBody;

import ca.ryerson.electives.domain.Category;
import ca.ryerson.electives.domain.Course;
import ca.ryerson.electives.domain.Subtheme;
import ca.ryerson.electives.domain.Theme;
import ca.ryerson.electives.services.CategoryService;
import ca.ryerson.electives.services.CourseService;
import ca.ryerson.electives.services.ElectiveHierarchyService;
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
	@Autowired
	ElectiveHierarchyService electiveHierarchyService;
     
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
	 public String getCourseList(@RequestParam(value = "theme", required = false, defaultValue = "0") int theme,
			 @RequestParam(value = "subtheme", required = false, defaultValue = "0") int subtheme,
			 @RequestParam(value = "category", required = false, defaultValue = "0") int category,
			 @RequestParam(value = "discipline", required = false, defaultValue = "") String discipline,
			 @RequestParam(value = "prereqs", required = false, defaultValue = "") String prereqs,
			 @RequestParam(value = "antireqs", required = false, defaultValue = "") String antireqs,
			 Locale locale, Model model) {  
		 
		 List<Course> courseList;
		 
		 if (theme > 0 || subtheme > 0 || category > 0 || discipline != "" || prereqs != "" || antireqs != "")
		 {
			 courseList = electiveHierarchyService.getCourseListFromHierarchy(theme,subtheme,category,discipline,prereqs,antireqs);  
		 }
		 else 
		 {
			 courseList = courseService.getCourseList();  
		 }
	  
	  List<Category> categoryList = categoryService.getCategoryList();
	  List<Theme> themeList = themeService.getThemeList();
	  List<Subtheme> subthemeList = subthemeService.getSubthemeList();

	  model.addAttribute("categoryList",categoryList);
	  model.addAttribute("courseList",courseList);
	  model.addAttribute("themeList",themeList);
	  model.addAttribute("subthemeList",subthemeList);

	  return "courseList";
	 }  

	 @RequestMapping(value = "/subthemes", method = RequestMethod.GET)
	 public @ResponseBody
	 List<Subtheme> subthemesForTheme(
	 		@RequestParam(value = "theme", required = true) int theme) {
	 	logger.debug("Finding Subthemes for Theme " + theme);
	 	return this.subthemeService.getSubthemesForTheme(theme);
	 }
	 
	 @RequestMapping(value = "/themecategories", method = RequestMethod.GET)
	 public @ResponseBody
	 List<Category> categoriesForTheme(
	 		@RequestParam(value = "theme", required = true) int theme) {
	 	logger.debug("Finding Categories for Theme " + theme);
	 	return this.categoryService.getCategoriesForTheme(theme);
	 }
	 
	 @RequestMapping(value = "/categories", method = RequestMethod.GET)
	 public @ResponseBody
	 List<Category> categoriesForSubtheme(
	 		@RequestParam(value = "subtheme", required = true) int subtheme) {
	 	logger.debug("Finding ategories for Subtheme " + subtheme);
	 	return this.categoryService.getCategoriesForSubtheme(subtheme);
	 }
	 
}
