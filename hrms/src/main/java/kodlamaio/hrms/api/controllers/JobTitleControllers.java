package kodlamaio.hrms.api.controllers;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.entities.concretes.JobTitles;


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
		public List<JobTitles> getAll(){
			return jobservice.getAll();
		}
}
