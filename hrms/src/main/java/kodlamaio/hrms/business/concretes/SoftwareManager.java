package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SoftwareService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SoftwareDao;
import kodlamaio.hrms.entities.concretes.candidateCv.Software;

@Service
public class SoftwareManager implements SoftwareService {
	
	@Autowired
	private SoftwareDao softwareDao;

	public SoftwareManager(SoftwareDao softwareDao) {
		super();
		this.softwareDao = softwareDao;
	}
	
	
	public Result addSoftware(Software software) {
		
		this.softwareDao.save(software);
		
		return new SuccessResult("verdiğiniz bilgiler başarılı bir şekilde eklendi");
	}

}
