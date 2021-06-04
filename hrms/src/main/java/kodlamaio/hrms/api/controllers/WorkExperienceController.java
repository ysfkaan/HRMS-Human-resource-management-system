package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.candidateCv.WorkExperience;

@RestController
@RequestMapping("/api/WorkExperience")
public class WorkExperienceController {
	@Autowired
	private WorkExperienceService service;

	public WorkExperienceController(WorkExperienceService service) {
		super();
		this.service = service;
	} 
	
	@PostMapping("/addWorkExperience")
	public Result addWorkExperience(@RequestBody WorkExperience workexperience) {
		return this.service.addWorkExperience(workexperience);
	}
}
