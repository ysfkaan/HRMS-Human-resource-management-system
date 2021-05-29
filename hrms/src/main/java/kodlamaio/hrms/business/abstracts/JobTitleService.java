package kodlamaio.hrms.business.abstracts;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;



@Service
public interface JobTitleService {
	
	DataResult<List<JobTitle>>  getAll(); 
	
	Result add(JobTitle jobtitle);
	

}
