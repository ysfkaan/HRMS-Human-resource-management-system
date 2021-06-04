package kodlamaio.hrms.api.controllers;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.Adapters.abstarcts.ImageService;
import kodlamaio.hrms.Adapters.concretes.ImageManager;
import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvDao;
import kodlamaio.hrms.entities.concretes.candidateCv.Photo;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {
	
	@Autowired
	private PhotoService photoService;
	private ImageManager imageService;
	private CandidateCvDao caniddiateCvDao;


	public PhotoController(PhotoService photoService, ImageManager imageService, CandidateCvDao caniddiateCvDao) {
		super();
		this.photoService = photoService;
		this.imageService = imageService;
		this.caniddiateCvDao = caniddiateCvDao;
	}


	
	
	
	@PostMapping("/addPhoto")
	public Result addPhoto(@RequestParam MultipartFile multipartFile ,@RequestParam int CandidateCvId) {
		try {
            BufferedImage bufferedImage= ImageIO.read(multipartFile.getInputStream());
            if(bufferedImage==null){
                return new ErrorResult("Resim validasyonu başarısız");
            }
        }catch (IOException exception){
            return new ErrorResult("Resim validasyonu başarısız");
        }

        try {
            Map result= this.imageService.upload(multipartFile);
            Photo photo=new Photo();
            photo.setUrl((String)result.get("url"));
            photo.setCandidateCv(this.caniddiateCvDao.findByCandidate_Id(CandidateCvId));
            
            
            
            return this.photoService.addPhoto(photo);
        }catch (IOException exception){
            return new ErrorResult("Resim yukleme aşamasında bir sorun oluştu");
        }
		
	}

}
