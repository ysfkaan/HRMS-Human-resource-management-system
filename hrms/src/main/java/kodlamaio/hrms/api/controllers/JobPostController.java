 package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import kodlamaio.hrms.business.abstracts.JobPostService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPost;
import lombok.RequiredArgsConstructor;




@RestController
@RequestMapping("/api/jobpost")

public class JobPostController {
	
	@Autowired
	private JobPostService jobpostservice;

	public JobPostController(JobPostService jobpostservice) {

		this.jobpostservice = jobpostservice;
	}

	@GetMapping("/getall")
	public DataResult<List<JobPost>>  getAll(){
		return this.jobpostservice.getAll();
	}
	

	@GetMapping("/getactivejob")
	public DataResult<List<JobPost>>  getAllActivejob(){
		return this.jobpostservice.findByisActiveTrue();
	}
	
	@GetMapping("/getactivejoborderDate")
	public DataResult<List<JobPost>>  getAllActivejobOrderDate(){
		return this.jobpostservice.getAllSorted();
	}
	@GetMapping("/getCompanyJobpost")
	public DataResult<List<JobPost>>  getcompnayJob(@RequestParam String companyName){
		return this.jobpostservice.getByEmployer_companyName(companyName);
	}	
	
	@PostMapping("/addjobpost")
	public DataResult<List<JobPost>> addJobPost(@RequestBody JobPost jobpost){
		return this.addJobPost(jobpost);
	}
	
	
	@PostMapping("updateActivationJobPost")
	public Result updateActivation(@RequestParam("id")int id,@RequestParam("isActive") boolean isActive) {
		return this.updateActivation(id, isActive);
	}
	
	
	
	
	
	
	
	
	
	
	
}
