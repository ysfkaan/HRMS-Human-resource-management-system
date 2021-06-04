package kodlamaio.hrms.business.concretes;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.languageDao;
import kodlamaio.hrms.entities.concretes.candidateCv.Language;

@Service
public class LanguageManager implements LanguageService {
	
	
	@Autowired
	private languageDao languageDao;

	public LanguageManager(languageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}
	
	public Result addLanguage(Language language) {
		
		this.languageDao.save(language);
		
		return new SuccessResult("verilen bilgiler eklenmiştir");
		
	}
}


