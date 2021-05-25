package kodlamaio.hrms.business.concretes;

import java.util.List;    

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.Adapters.abstarcts.FakeMernisAdapterService;


import kodlamaio.hrms.business.abstracts.ICandidateService;
import kodlamaio.hrms.core.utilities.Auth.abstarcts.EmailVerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;


@Service
public class CandidateManager implements ICandidateService {
	
	
	@Autowired
	private CandidateDao candidatedao ;
	private EmailVerificationService emailverification;
	private FakeMernisAdapterService adapter;

	public CandidateManager(CandidateDao candidatedao, EmailVerificationService emailverification,
			FakeMernisAdapterService adapter) {
		super();
		this.candidatedao = candidatedao;
		this.emailverification = emailverification;
		this.adapter = adapter;
	}


	
	

	@Override
	public DataResult <List<Candidate>>  getAll() {
		
		return new SuccessDataResult <List<Candidate>>  
		(this.candidatedao.findAll(),"Data Listelendi");
	}
	
	
	
	
	
	
	
	
	@Override
	public Result addCandidate(Candidate candidate) {
		
		if(!CheckMail(candidate)) {
			return new ErrorResult("Mail doğrulaması gerçekleşmedi");
			
		}else if(!CheckMernis(candidate)) {
			return new ErrorResult("Mernis doğrulaması gerçekleşmedi");
			
		}else if(!isNotnull(candidate)){
			return new ErrorResult("Tüm alanlar doldurulmak zorundadır ");
			
		}else if(candidatedao.findAllByIdentificationNumber(candidate.getIdentificationNumber()).stream().count() != 0 ) {
			return new ErrorDataResult<Candidate>(null,"TC Numarası Zaten Kayıtlı");
			
		}
		else if(candidatedao.findAllByEmail(candidate.getEmail()).stream().count() != 0 ) {
			return new ErrorDataResult<Candidate>(null,"Email Zaten Kayıtlı");
		}
		else {
			this.candidatedao.save(candidate);
			return new SuccessResult("Kaydınız başarıyla gerçekleşmiştir");
		}
			
		
		}
	
	
	
	
	
	public boolean  CheckMail(Candidate candidate) {
		
		return this.emailverification.CheckMail(candidate);
	}
	
	
	public boolean CheckMernis(Candidate candidate) {
		return adapter.IfRealCheckPerson(candidate);
		}
	
	
	
	public boolean isNotnull(Candidate candidate) {
		if(candidate.getEmail().isBlank() &&
			candidate.getFirstName().isBlank() &&
			candidate.getBirthDate()!=null && 
			candidate.getPassword().isBlank()  &&
			candidate.getLastName().isBlank() &&
			candidate.getIdentificationNumber().isBlank() )
		{
			
			return true;
		}else {
			return false;
		}
	
		
	}
		
		
		
		
	}
	
	
	

	
	
	










		
		
	
