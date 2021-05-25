package kodlamaio.hrms.core.utilities.Auth.concretes;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.Auth.abstarcts.EmailVerificationService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;


@Service
public class EmailVerificationManager implements EmailVerificationService {
	private String regex = "^(.+)@(.+)$";
	
	

	@Override
	public boolean CheckMail(Candidate candidate) {
		Pattern pattern =Pattern.compile(regex);
		Matcher matcher = pattern.matcher(candidate.getEmail());
		if (matcher.find()) {
			return true;
			
		}else {
			return false;
		}
		
		
		
		
	}


	@Override
	public boolean CheckMail(Employer employer) {
	return false;
	
	}

}

