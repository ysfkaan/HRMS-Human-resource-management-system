package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkExperienceDao;
import kodlamaio.hrms.entities.concretes.candidateCv.WorkExperience;

@Service
public class WorkExperienceManager implements  WorkExperienceService{
	
	
	@Autowired
	private WorkExperienceDao workExperienceDao;

	public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
		super();
		this.workExperienceDao = workExperienceDao;
	}
	
	
	public Result addWorkExperience(WorkExperience workexperience) {
		
		this.workExperienceDao.save(workexperience);
		return new SuccessResult("verilen bilgiler başarılı bir şekilde eklendi");
		
	}
	
}
