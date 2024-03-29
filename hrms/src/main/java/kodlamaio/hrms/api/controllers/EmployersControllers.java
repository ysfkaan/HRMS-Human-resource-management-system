package kodlamaio.hrms.api.controllers;

import java.util.List;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.IEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.main.Employer;



@RestController
@RequestMapping("/api/employer")
public class EmployersControllers {
	
	@Autowired
	private IEmployerService employerservice;

	public EmployersControllers(IEmployerService employerservice) {
		super();
		this.employerservice = employerservice;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>>  getAll(){
		
		return this.employerservice.getAll(); 
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		
		return this.employerservice.addEmployer(employer);
	}
	

	
	
}
