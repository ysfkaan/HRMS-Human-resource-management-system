package kodlamaio.hrms.business.concretes;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.IEmployerService;
import kodlamaio.hrms.core.utilities.Auth.abstarcts.EmailVerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;


@Service
public class EmployerManager implements IEmployerService{

	




	@Autowired
	private EmployerDao employerdao;
	private EmailVerificationService emailverification;



	public EmployerManager(EmployerDao employer, EmailVerificationService emailverification) {
		super();
		this.employerdao = employerdao;
		this.emailverification=emailverification;
	}



	@Override
	public DataResult <List<Employer>>  getAll() {
		
		return new SuccessDataResult<List<Employer>> (this.employerdao.findAll() ," Data listelendi");
	}



	@Override
	public Result addEmployer(Employer employer) {
		if(isNotNull(employer)) {
			return new ErrorResult("Eksik bilgi olmamalıdır ");
			
		}else if (employerdao.existsEmployerByEmail(employer.getEmail())) {
			return new ErrorResult("Girdiğiniz email sisteme kayıtlıdır");
			
		}else if(this.CheckMail(employer)) {
			return new ErrorResult("Mail doğrulaması gerçekleşmedi");
			
		}else {
		
			this.employerdao.save(employer);
		return new SuccessResult("Kayıt tamamlandı");
		}
		
		
		

		
	}
	
	
	public boolean  isNotNull(Employer employer) {
		if( employer.getEmail().isEmpty()||
			employer.getPassword().isBlank() ||
			employer.getCompanyName().isEmpty() ||
			employer.getWebAddress().isEmpty()){
				return true;
		}else {
			    return false;
		}
		
	
	}
	public boolean CheckMail(Employer employer) {
		return this.emailverification.CheckMail(employer);
		 
	}

}
