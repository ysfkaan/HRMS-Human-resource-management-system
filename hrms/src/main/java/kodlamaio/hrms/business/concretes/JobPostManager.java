package kodlamaio.hrms.business.concretes;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import kodlamaio.hrms.business.abstracts.JobPostService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostDao;
import kodlamaio.hrms.entities.concretes.post.JobPost;

@Service
public class JobPostManager implements JobPostService{
	
	@Autowired
	private JobPostDao jobpostdao;

	public JobPostManager(JobPostDao jobpostdao) {
		
		this.jobpostdao = jobpostdao;
	}
	
	
	
	@Override
	public DataResult <List<JobPost>>  getAll() {
		
		return new SuccessDataResult <List<JobPost>>  
		(this.jobpostdao.findAll(),"Data Listelendi");
	}
	
	@Override
	public DataResult <List<JobPost>>  findByisActiveTrue(){
		
		return new SuccessDataResult <List<JobPost>>  
		(this.jobpostdao.findByisActiveTrue(),"Aktif iş ilanları Listelendi");
	}
	
	
	@Override
	public DataResult<List<JobPost>> getAllSorted(){
		Sort sort = Sort.by(Sort.Direction.DESC,"applicationdeadline");
		return new SuccessDataResult<List<JobPost>>
		(this.jobpostdao.findAll(sort),"Başarılı");
	}



	@Override
	public DataResult<List<JobPost>> getByEmployer_companyName(String companyName) {
		
		return new SuccessDataResult<List<JobPost>>
		(this.jobpostdao.getByEmployer_companyName(companyName),"Başarılı");
	}
	

	@Override
	public Result add(JobPost jobpost) {
		this.jobpostdao.save(jobpost);
		return new SuccessResult("eklendi");

	
	}
	
	public Result updateActivasion(int id ,boolean isActive) {
		
		this.jobpostdao.updateisActive(id,isActive);
		return new SuccessResult ("güncelleme yapıldı");
	}
	
	
	
	
	}
