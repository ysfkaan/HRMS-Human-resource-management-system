package kodlamaio.hrms.business.concretes;

import java.util.List;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.IEmployerService;

import kodlamaio.hrms.core.utilities.registerRule.abstarcts.EmployerRuleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;

import kodlamaio.hrms.entities.concretes.Employer;


@Service
public class EmployerManager implements IEmployerService{

	
	@Autowired
	private EmployerDao employerdao;
	private EmployerRuleService employerRule;
	
	public EmployerManager(EmployerDao employerdao, EmployerRuleService employerRule) {
		super();
		this.employerdao = employerdao;
		this.employerRule = employerRule;
	}

	@Override
	public DataResult <List<Employer>>  getAll() {
		
		return new SuccessDataResult<List<Employer>> (this.employerdao.findAll() ," Data listelendi");
	}



	
	
	
	@Override
	public Result addEmployer(Employer employer) {
		
		if(!this.employerRule.checkMail(employer)) {
				return new ErrorResult("Hatalı Mail ");
		
				
		}else if (!this.employerRule.checkPassword(employer)) {
				return new ErrorResult("Hatalı şifre");
			
				
		}else if(!this.employerRule.checkWebsite(employer)) {
				return new ErrorResult("Hatalı web sitesi");
				
			
		}else if (!this.employerRule.checkCompanyName(employer)){
				return new ErrorResult("Hatalı şirket ismi");
		
		
		}else if (!this.employerRule.verificationMail(employer)){
			return new ErrorResult("Mailiniz doğrulanamadı");
		
			
		}else if(this.employerdao.findAllByEmail(employer.getEmail()).stream().count() != 0 ) {
			return new ErrorResult("Email Zaten Kayıtlı");

			
			
		}this.employerdao.save(employer);
		return new SuccessResult("iş veren Kaydı tamamlandı");
		}
		
		
		

		
	}
	
	
	
