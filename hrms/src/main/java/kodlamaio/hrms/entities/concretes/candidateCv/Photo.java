package kodlamaio.hrms.entities.concretes.candidateCv;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="photos")
@NoArgsConstructor
@AllArgsConstructor
public class Photo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="photo_id")
	private int id;
	
	
	@Column(name="photo_url")
	private String url;
	
	@ManyToOne()
	@JoinColumn(name="candidateCv_id")
	private CandidateCv candidateCv;	

}
