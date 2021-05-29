package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobPost;

public interface JobPostDao extends JpaRepository<JobPost, Integer>{
	
	
	
	List<JobPost> findByisActiveTrue();
	List<JobPost> getByEmployer_companyName(String companyName);
	@Query("Update JobPost Set isActive=:isActive Where id=:id ")
	JobPost updateisActive(int id, boolean isActive);


}
