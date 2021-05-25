package kodlamaio.hrms.core.utilities.Auth.abstarcts;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;


public interface EmailVerificationService {
	boolean CheckMail(Candidate candidate);
	boolean CheckMail(Employer employer);
}
