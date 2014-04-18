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

import ca.ryerson.electives.domain.Semester;
import ca.ryerson.electives.domain.SubCategory;
import ca.ryerson.electives.domain.Course;
import ca.ryerson.electives.domain.Category;
import ca.ryerson.electives.domain.Theme;
import ca.ryerson.electives.services.SemesterService;
import ca.ryerson.electives.services.SubCategoryService;
import ca.ryerson.electives.services.CourseService;
import ca.ryerson.electives.services.ElectiveHierarchyService;
import ca.ryerson.electives.services.CategoryService;
import ca.ryerson.electives.services.ThemeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired  
	 CourseService courseService;
	@Autowired
     SubCategoryService subcategoryService;
	@Autowired
	 ThemeService themeService;
	@Autowired
	 CategoryService categoryService;
	@Autowired
	ElectiveHierarchyService electiveHierarchyService;
	@Autowired
	SemesterService semesterService;
     
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
	
	@RequestMapping(value = "/descriptions", method = RequestMethod.GET)
	public String descriptions(Locale locale, Model model) {
				
		return "descriptions";
	}
	
	 @RequestMapping(value= "/getCourseList",method = RequestMethod.GET)  
	 public String getCourseList(@RequestParam(value = "theme", required = false, defaultValue = "0") int theme,
			 @RequestParam(value = "category", required = false, defaultValue = "0") int category,
			 @RequestParam(value = "subcategory", required = false, defaultValue = "0") int subcategory,
			 @RequestParam(value = "discipline", required = false, defaultValue = "") String discipline,
			 @RequestParam(value = "prereqs", required = false, defaultValue = "") String prereqs,
			 @RequestParam(value = "antireqs", required = false, defaultValue = "") String antireqs,
			 @RequestParam(value = "semester", required = false, defaultValue = "0") int semester,
			 Locale locale, Model model) {  
		 
		 List<Course> courseList;
		 
		 if (theme > 0 || category > 0 || subcategory > 0 || discipline != "" || prereqs != "" || antireqs != "" || semester > 0)
		 {
			 courseList = electiveHierarchyService.getCourseListFromHierarchy(theme,category,subcategory,discipline,prereqs,antireqs,semester);  
		     model.addAttribute("selectSemester", semester);
		     model.addAttribute("selectTheme",theme);
		     model.addAttribute("selectCategory",category);
		     model.addAttribute("selectSubCategory",subcategory);
		     model.addAttribute("selectDiscipline",discipline);
		     model.addAttribute("selectPrerequisites",prereqs);
		     model.addAttribute("selectAntirequisites",antireqs);
		 }
		 else 
		 {
			 courseList = courseService.getCourseList();  
		 }
	  
	  List<Semester> semesterList = semesterService.getActiveSemesterList(); 
	  List<SubCategory> subcategoryList = subcategoryService.getSubCategoryList();
	  List<Theme> themeList = themeService.getThemeList();
	  List<Category> categoryList = categoryService.getCategoryList();

	  model.addAttribute("subcategoryList",subcategoryList);
	  model.addAttribute("courseList",courseList);
	  model.addAttribute("themeList",themeList);
	  model.addAttribute("categoryList",categoryList);
	  model.addAttribute("semesterList",semesterList);

	  return "courseList";
	  
	 }  

	 @RequestMapping(value = "/categories", method = RequestMethod.GET)
	 public @ResponseBody
	 List<Category> categoriesForTheme(
	 		@RequestParam(value = "theme", required = true) int theme) {
	 	logger.debug("Finding Categories for Theme " + theme);
	 	return this.categoryService.getCategoriesForTheme(theme);
	 }
	 
	 @RequestMapping(value = "/themesubcategories", method = RequestMethod.GET)
	 public @ResponseBody
	 List<SubCategory> subCategoriesForTheme(
	 		@RequestParam(value = "theme", required = true) int theme) {
	 	logger.debug("Finding Sub-Categories for Theme " + theme);
	 	return this.subcategoryService.getSubCategoriesForTheme(theme);
	 }
	 
	 @RequestMapping(value = "/subcategories", method = RequestMethod.GET)
	 public @ResponseBody
	 List<SubCategory> subCategoriesForCategory(
	 		@RequestParam(value = "category", required = true) int category) {
	 	logger.debug("Finding Sub-categories for Category " + category);
	 	return this.subcategoryService.getSubCategoriesForCategory(category);
	 }
	 
}
