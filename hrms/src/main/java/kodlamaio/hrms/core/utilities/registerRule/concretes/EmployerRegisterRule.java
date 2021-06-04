package kodlamaio.hrms.core.utilities.registerRule.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.Auth.abstarcts.EmailVerificationService;
import kodlamaio.hrms.core.utilities.registerRule.abstarcts.EmployerRuleService;
import kodlamaio.hrms.entities.concretes.main.Employer;



@Service
public class EmployerRegisterRule implements EmployerRuleService{
	private String Mailregex = "^(.+)@(.+)$";
	private String Webregex="^(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$";
	
	@Autowired
	private EmailVerificationService emailverification;
	public EmployerRegisterRule(EmailVerificationService emailverification) {
		super();
		this.emailverification = emailverification;
	}



	public boolean result (Employer employer) {
		if( this.checkMail(employer)        &&
			this.checkPassword(employer)    &&
			this.checkCompanyName(employer) &&
			this.checkWebsite(employer)     &&
			this.verificationMail(employer)) {
			return true;
		}else {
			return false;
		}
		
	
	}
	
	
	
	public boolean checkMail(Employer employer) {
		Pattern pattern =Pattern.compile(Mailregex);
		Matcher matcher = pattern.matcher(employer.getEmail());
		
		if( employer.getEmail().isEmpty()      ||
			employer.getEmail()==null	       || 
			employer.getEmail().length() <=8   || 
			employer.getEmail().length() >=100 || 
			!matcher.find()) {
			return false;
		}else {return true ;
		}}
	
	public boolean checkPassword(Employer employer) {
		if (employer.getPassword().isEmpty()     ||
			employer.getPassword()==null		 ||
			employer.getPassword().length()<= 3  ||
			employer.getPassword().length()>=100) {
			return false;
		}else {
			return true;
		}}
	
	public boolean checkCompanyName(Employer employer) {
		if( employer.getCompanyName().isEmpty()     ||
		    employer.getCompanyName()==null         ||
			employer.getCompanyName().length()<=2   ||
			employer.getCompanyName().length()>=100) {
			return false;
		}else {
			return true;
		}}
	
	public boolean checkWebsite(Employer employer) {
		Pattern pattern =Pattern.compile(Webregex);
		Matcher matcher = pattern.matcher(employer.getWebAddress());
		
		if( employer.getEmail().isEmpty()      ||
			employer.getEmail()==null	       || 
			employer.getEmail().length() <=8   || 
			employer.getEmail().length() >=100 || 
			!matcher.find()) {
			
			return false;
		}else {return true ;
		}}
	
	
	public boolean verificationMail(Employer employer) {
		return this.emailverification.CheckMail(employer);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
