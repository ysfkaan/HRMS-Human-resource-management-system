package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPost;

@Service
public interface JobPostService {
	
	DataResult <List<JobPost>>  getAll();
	DataResult<List<JobPost>> getAllSorted();

	DataResult <List<JobPost>>  findByisActiveTrue();
	DataResult <List<JobPost>> getByEmployer_companyName(String companyName);
	Result add(JobPost jobpost);
	Result updateActivasion(int id ,boolean isActive);

	

}
