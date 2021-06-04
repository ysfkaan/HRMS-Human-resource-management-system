package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.candidateCv.Software;

public interface SoftwareDao extends JpaRepository<Software, Integer> {

}
