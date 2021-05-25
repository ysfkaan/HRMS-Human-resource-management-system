package kodlamaio.hrms.business.concretes;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitlesDao;

import kodlamaio.hrms.entities.concretes.JobTitles;

@Service
public class JobTitleManager implements JobTitleService {
	
	
	@Autowired
	private JobTitlesDao jobtitlesdao;

	public JobTitleManager(JobTitlesDao jobtitlesdao) {
		super();
		this.jobtitlesdao = jobtitlesdao;
	}


	@Override
	public DataResult  getAll() {
		
		return new SuccessDataResult<List<JobTitles>>(this.jobtitlesdao.findAll());
				
	}
	
	
	
	public Result add(JobTitles jobtitle) {
		
		this.jobtitlesdao.save(jobtitle);
		return new SuccessResult("iş pozisyonu eklendi");
		
	}


}
