package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.candidateCv.Software;

public interface SoftwareService {
	Result addSoftware(Software software);
}
