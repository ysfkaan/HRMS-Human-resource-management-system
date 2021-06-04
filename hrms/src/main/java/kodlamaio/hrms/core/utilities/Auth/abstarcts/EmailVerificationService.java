package kodlamaio.hrms.core.utilities.Auth.abstarcts;

import kodlamaio.hrms.entities.concretes.main.Candidate;
import kodlamaio.hrms.entities.concretes.main.Employer;


public interface EmailVerificationService {
	boolean CheckMail(Candidate candidate);
	boolean CheckMail(Employer employer);
}
