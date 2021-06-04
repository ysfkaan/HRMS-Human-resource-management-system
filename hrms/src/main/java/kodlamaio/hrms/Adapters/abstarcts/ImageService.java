package kodlamaio.hrms.Adapters.abstarcts;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface ImageService {
	
	 Map upload(MultipartFile multipartFile) throws IOException;
}
