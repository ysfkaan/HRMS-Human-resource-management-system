package kodlamaio.hrms.core.utilities.registerRule.abstarcts;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateRuleService {
	boolean result(Candidate candidate) ;
	boolean checkMail(Candidate candidate);
	boolean checkPassword(Candidate candidate);
	boolean checkFirstName(Candidate candidate);
	boolean checkLastName(Candidate candidate);
	boolean checkidNumber(Candidate candidate);
	boolean checkBirthDate(Candidate candidate);
	 boolean verificationMail(Candidate candidate);
	 boolean verificationMernis(Candidate candidate);
}
