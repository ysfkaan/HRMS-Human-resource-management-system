package kodlamaio.hrms.Adapters.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import kodlamaio.hrms.Adapters.abstarcts.ImageService;

@Service
public class ImageManager implements ImageService {

	Cloudinary cloudinary;
	private Map<String, String> valuesMap = new HashMap<>();

	public ImageManager() {
		valuesMap.put("cloud_name", "dggpe5ypa");
		valuesMap.put("api_key", "127712333271646");
		valuesMap.put("api_secret", "TZb6GrpvmTtMjlF9qCwWX91fkm4");
		cloudinary = new Cloudinary(valuesMap);
	}

	

	public Map upload(MultipartFile multipartFile) throws IOException {
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream stream = new FileOutputStream(file);
		stream.write(multipartFile.getBytes());
		stream.close();
		
		 Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
	     file.delete();
	     return result;
	}

}
