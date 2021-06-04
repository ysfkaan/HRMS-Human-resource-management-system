package kodlamaio.hrms.api.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateCvService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.candidateCv.CandidateCv;

@RestController
@RequestMapping("/api/canidateCv")
public class CandidatesCvController {
	
	@Autowired
	private CandidateCvService candidateCvService;

	public CandidatesCvController(CandidateCvService candidateCvService) {
		super();
		this.candidateCvService = candidateCvService;
	}
	
	@PostMapping("/addCanddiateCv")
	public Result addCandidateCv(@RequestBody CandidateCv candidatecv) {
		
		
		return this.candidateCvService.addCv(candidatecv); 
	}
	
	

	
	
	
}
