package kodlamaio.hrms.entities.concretes.candidateCv;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="work_experiences")
@NoArgsConstructor
@AllArgsConstructor
public class WorkExperience {
	
	@Column(name="id")
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	
	@Column(name="business_name")
	private String businessName;
	
	@Column(name="position")
	private String position;
	
	@Column(name="start_date")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	private Date startDate;
	
	@Column(name="end_date")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	private Date endDate;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne()
	@JoinColumn(name="candidatesCv_id")
	private CandidateCv candidateCv;
	

}
