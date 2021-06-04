package kodlamaio.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.post.JobTitle;

public interface JobTitlesDao extends JpaRepository<JobTitle,Integer> {

}
