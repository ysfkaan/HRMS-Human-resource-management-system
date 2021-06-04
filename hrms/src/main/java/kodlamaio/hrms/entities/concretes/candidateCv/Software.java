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


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="software")
@NoArgsConstructor
@AllArgsConstructor
public class Software {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="software_name")
	private String softwareName;
	
	@Column(name="software_level")
	private int SoftwareLevel;
	
	
	@ManyToOne()
	@JoinColumn(name="candidateCv_id")
	private CandidateCv candidateCv;
}
