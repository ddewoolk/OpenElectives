package ca.ryerson.electives.services;

/** 
 * 
 * @author 
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ca.ryerson.electives.dao.SemesterDao;
import ca.ryerson.electives.domain.Semester;

public class SemesterServiceImpl implements SemesterService {

	@Autowired
	SemesterDao semesterDao;

	@Override
	public List<Semester> getSemesterList() {
		return semesterDao.getSemesterList();
	}
	
	@Override
	public List<Semester> getActiveSemesterList() {
		return semesterDao.getActiveSemesterList();
	}

}
