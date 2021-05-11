package kodlamaio.hrms.business.concretes;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.dataAccess.abstracts.JobTitlesDao;

import kodlamaio.hrms.entities.concretes.JobTitles;

@Service
public class JobTitleManager implements JobTitleService {
	
	
	@Autowired
	private JobTitlesDao jobtitlesdao;
	
	public JobTitleManager() {
		
	}





	@Override
	public List<JobTitles> getAll() {
		
		return this.jobtitlesdao.findAll();
	}

}
