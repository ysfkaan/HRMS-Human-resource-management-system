package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SoftwareService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.candidateCv.Software;

@RestController
@RequestMapping("/api/software")
public class SoftwareController {
	
	@Autowired
	private SoftwareService softwareService;

	public SoftwareController(SoftwareService softwareService) {
		super();
		this.softwareService = softwareService;
	}
	
	@PostMapping("/addSoftware")
	public Result addSoftware(@RequestBody Software software) {
		return this.softwareService.addSoftware(software);
		
	}

}
