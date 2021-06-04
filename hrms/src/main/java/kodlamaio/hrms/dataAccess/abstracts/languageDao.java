package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.candidateCv.Language;

public interface languageDao extends JpaRepository<Language, Integer>{

}
