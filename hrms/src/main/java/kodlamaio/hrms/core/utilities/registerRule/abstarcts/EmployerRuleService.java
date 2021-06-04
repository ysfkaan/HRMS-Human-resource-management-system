package kodlamaio.hrms.core.utilities.registerRule.abstarcts;

import kodlamaio.hrms.entities.concretes.main.Employer;

public interface EmployerRuleService {
	boolean result (Employer employer);
	boolean checkMail(Employer employer);
	boolean checkPassword(Employer employer);
	boolean checkCompanyName(Employer employer);
	boolean checkWebsite(Employer employer);
	boolean verificationMail(Employer employer);

}
