package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.main.Candidate;
import kodlamaio.hrms.entities.concretes.main.Employer;

public interface EmployerDao extends JpaRepository<Employer ,Integer>{
	
	
	List<Employer> findAllByEmail(String email);
}
