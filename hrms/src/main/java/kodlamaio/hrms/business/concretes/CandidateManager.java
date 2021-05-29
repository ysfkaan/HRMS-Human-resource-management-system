package kodlamaio.hrms.business.concretes;

import java.util.List;      
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.ICandidateService;
import kodlamaio.hrms.core.utilities.registerRule.abstarcts.CandidateRuleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
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
	private CandidateRuleService candidateRule;

	public CandidateManager(CandidateDao candidatedao, CandidateRuleService candidateRule) {
		super();
		this.candidatedao = candidatedao;
		this.candidateRule = candidateRule;
	}
	@Override
	public DataResult <List<Candidate>>  getAll() {
		
		return new SuccessDataResult <List<Candidate>>  
		(this.candidatedao.findAll(),"Data Listelendi");
	}

	
	
	
	@Override
	public Result addCandidate(Candidate candidate) {
		
		
		if(!this.candidateRule.checkMail(candidate)) {
			return new ErrorResult("Hatalı mail");
		
			
		}else if(!this.candidateRule.checkPassword(candidate)) {
			return new ErrorResult("Hatalı şifre");
			
			
		}else if(!this.candidateRule.checkFirstName(candidate)){
			return new ErrorResult("hatalı isim  ");
			
			
		}else if(!this.candidateRule.checkLastName(candidate)) {
			return new ErrorResult("hatalı soyisim  ");
		
			
			
		}else if(!this.candidateRule.checkidNumber(candidate)) {
			return new ErrorResult("hatalı Tckimlik no  ");
			
			
		}else if(!this.candidateRule.checkBirthDate(candidate)) {
			return new ErrorResult("hatalı doğum tarihi  ");
		
		
		}else if(!this.candidateRule.verificationMail(candidate)) {
			return new ErrorResult("Mail doğrulaması gerçekleşmedi ");
		
		
		}else if(!this.candidateRule.verificationMernis(candidate)) {
			return new ErrorResult("Mernis sistemiyle doğrulanamadı ");
		
		
		}else if(this.candidatedao.findAllByIdentificationNumber(candidate.getIdentificationNumber()).stream().count() != 0 ) {
			return new ErrorResult("TC Numarası Zaten Kayıtlı");
		
			
		}else if(this.candidatedao.findAllByEmail(candidate.getEmail()).stream().count() != 0 ) {
			return new ErrorResult("Email Zaten Kayıtlı");
		
		
		}else {
			this.candidatedao.save(candidate);
			return new SuccessResult("İş arayan Kaydınız başarıyla gerçekleşmiştir");
		}}
	
	
	
	
	
}
	
	

	
	
	










		
		
	
