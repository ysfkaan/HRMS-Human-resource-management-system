package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.candidateCv.Photo;

public interface PhotoService {
	
	Result addPhoto(Photo photo);

}
