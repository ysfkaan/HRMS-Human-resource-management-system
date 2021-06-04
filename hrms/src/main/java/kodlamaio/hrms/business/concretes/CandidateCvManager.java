package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.Adapters.abstarcts.ImageService;
import kodlamaio.hrms.business.abstracts.CandidateCvService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvDao;
import kodlamaio.hrms.entities.concretes.candidateCv.CandidateCv;


@Service
public class CandidateCvManager implements CandidateCvService {
	
	private CandidateCvDao candidateCvDao;

	
	@Autowired
	public CandidateCvManager(CandidateCvDao candidateCvDao) {
		super();
		this.candidateCvDao = candidateCvDao;

	}

	
	
	
	
	
	@Override
	public Result addCv(CandidateCv candidateCv) {
		this.candidateCvDao.save(candidateCv);
		return new  SuccessResult("Cv eklendi");
	}







	

	
	
	
	
	
}
