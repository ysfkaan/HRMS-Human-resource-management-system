package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.candidateCv.WorkExperience;

public interface WorkExperienceService {
	Result addWorkExperience(WorkExperience workexperience) ;
}
