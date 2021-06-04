package kodlamaio.hrms.api.controllers;

import java.util.List;     

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.post.JobTitle;



@RestController
@RequestMapping("/api/jobtitles")

public class JobTitleControllers {
	
		private JobTitleService jobservice;
	
		@Autowired
		public JobTitleControllers(JobTitleService jobservice) {
		super();
		this.jobservice = jobservice;
	}

		@GetMapping("/getall")
		public DataResult<List<JobTitle>>  getAll(){
			return jobservice.getAll();
		}
		
		@PostMapping("/add")
		public Result add(@RequestBody JobTitle jobtitle) {
			return this.jobservice.add(jobtitle);
			
		}

}
