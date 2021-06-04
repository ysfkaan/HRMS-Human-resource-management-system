package kodlamaio.hrms.entities.concretes.candidateCv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import kodlamaio.hrms.entities.concretes.main.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="languages")
@NoArgsConstructor
@AllArgsConstructor
public class Language {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="language_name")	
	private String languageName;
	
	
	@Column(name="language_level")
	private String languageLevel;
	
	@ManyToOne()
	@JoinColumn(name="candidatecv_id")
	private CandidateCv candidateCv;
	

}
