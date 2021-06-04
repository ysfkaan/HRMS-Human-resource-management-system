package kodlamaio.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.candidateCv.CandidateCv;

public interface CandidateCvDao extends JpaRepository<CandidateCv, Integer>{
	
	
	CandidateCv findByCandidate_Id(int id);
}
