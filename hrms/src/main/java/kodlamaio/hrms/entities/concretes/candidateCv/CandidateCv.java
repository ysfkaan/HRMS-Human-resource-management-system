package kodlamaio.hrms.entities.concretes.candidateCv;



import java.util.List; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlamaio.hrms.entities.concretes.main.Candidate;
import kodlamaio.hrms.entities.concretes.main.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidatesCv")
@NoArgsConstructor
@AllArgsConstructor
public class CandidateCv {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_id")
	private int cvId;
	
	@OneToMany()
	@JoinColumn(name="user_id")
	private List<Candidate> candidate;
	
	
	@OneToMany()
	@JoinColumn(name="work_experience_id")
	private List<WorkExperience> workexperience;
	
	
	@OneToMany()
	@JoinColumn(name="language_id")
	private List<Language> language;
	
	@OneToMany()
	@JoinColumn(name="photo_id")
	private List<Photo> photo;
	
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linkeedin_link")
	private String linkeedinLink;
	
	
	@OneToMany()
	@JoinColumn(name="software_id")
	private List<Software> software;
	
	@Column(name ="about")
	private String about;
	
	@OneToMany()
	@JoinColumn(name="education_id")
	private List<Education> education;
	
	
	
	
	
	
	
}
