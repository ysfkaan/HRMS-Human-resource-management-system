package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.candidateCv.Language;

public interface LanguageService {
	
	Result addLanguage(Language language);
}
