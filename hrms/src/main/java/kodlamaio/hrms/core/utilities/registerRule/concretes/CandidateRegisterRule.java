package kodlamaio.hrms.core.utilities.registerRule.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.Adapters.abstarcts.FakeMernisAdapterService;
import kodlamaio.hrms.core.utilities.Auth.abstarcts.EmailVerificationService;
import kodlamaio.hrms.core.utilities.registerRule.abstarcts.CandidateRuleService;
import kodlamaio.hrms.entities.concretes.Candidate;



@Service
public class CandidateRegisterRule  implements CandidateRuleService {
	private String regex = "^(.+)@(.+)$";
	@Autowired
	private EmailVerificationService emailverification;
	private FakeMernisAdapterService  mernisadapter;
	
	public CandidateRegisterRule(EmailVerificationService emailverification, FakeMernisAdapterService mernisadapter) {
		super();
		this.emailverification = emailverification;
		this.mernisadapter = mernisadapter;
	}
	
	

	public boolean result(Candidate candidate) {
		
		if (this.checkMail(candidate)       &&
			this.checkPassword(candidate)	&&
			this.checkFirstName(candidate)  &&
			this.checkLastName(candidate)   &&
			this.checkidNumber(candidate)   &&
			this.checkBirthDate(candidate)  &&
			this.verificationMail(candidate)&&
			this.verificationMernis(candidate)) {
			return true ;
			
		}else {
			return false;
		}
		
	}
	
	
	
	
	public boolean checkMail(Candidate candidate) {
		Pattern pattern =Pattern.compile(regex);
		Matcher matcher = pattern.matcher(candidate.getEmail());
		
		if( candidate.getEmail().isBlank()      || 
			candidate.getEmail()==null	        || 
			candidate.getEmail().length() <=8   ||
			candidate.getEmail().length() >=100 ||
			!matcher.find()) {
			return false;
		}else{return true ;
		}}
		
	public boolean checkPassword(Candidate candidate) {
		if (candidate.getPassword().isEmpty()    ||
			candidate.getPassword()==null		 ||
			candidate.getPassword().length()<= 3 ||
			candidate.getPassword().length()>=100) {
			return false;
		}else {
			return true;
		}
	}
	public boolean checkFirstName(Candidate candidate) {
		if(candidate.getFirstName().isEmpty()     ||
			candidate.getFirstName()==null        ||
			candidate.getFirstName().length()<=2  ||
			candidate.getFirstName().length()>=100) {
			return false;
		}else {
			return true;
		}}
		public boolean checkLastName(Candidate candidate) {
			if(candidate.getLastName().isEmpty()     ||
				candidate.getLastName()==null        ||
				candidate.getLastName().length()<=2  ||
				candidate.getLastName().length()>=100) {
				return false;
			}else {
				return true;
			}}
		
		
		public boolean checkidNumber(Candidate candidate) {
	
			if(candidate.getIdentificationNumber().length()==11) {
			
				return true;
			}else {
				return false;
			}}
		
		
		public boolean checkBirthDate(Candidate candidate) {
			
			return true;
			}
		
		public boolean verificationMail(Candidate candidate) {
			return this.emailverification.CheckMail(candidate);
		}
		
		public boolean verificationMernis(Candidate candidate) {
			return this.mernisadapter.IfRealCheckPerson(candidate);
		}
		
		
	}
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		

