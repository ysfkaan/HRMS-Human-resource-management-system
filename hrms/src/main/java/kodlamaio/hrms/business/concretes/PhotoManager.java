package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PhotoDao;
import kodlamaio.hrms.entities.concretes.candidateCv.Photo;
@Service
public class PhotoManager implements PhotoService {
	
	@Autowired
	private PhotoDao photoDao;

	public PhotoManager(PhotoDao photoDao) {
		super();
		this.photoDao = photoDao;
	}
	
	public Result addPhoto(Photo photo) {
		this.photoDao.save(photo);
		return new SuccessResult("girilen bilgiler eklendi");
		
	}

}
