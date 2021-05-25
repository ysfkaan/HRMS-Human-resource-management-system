package kodlamaio.hrms.core.utilities.Auth.concretes;




import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.Auth.abstarcts.EmailVerificationService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;


@Service
public class EmailVerificationManager implements EmailVerificationService {
	

	@Override
	public boolean CheckMail(Candidate candidate) {
		
		return true;
	}
		
	
	@Override
	public boolean CheckMail(Employer employer) {
	return true;
	
	}

}

