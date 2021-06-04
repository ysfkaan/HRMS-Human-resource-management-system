package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.candidateCv.WorkExperience;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer> {

}
