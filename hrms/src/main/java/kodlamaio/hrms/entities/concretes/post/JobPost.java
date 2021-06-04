package kodlamaio.hrms.entities.concretes.post;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import kodlamaio.hrms.entities.concretes.main.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="jobpostings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class JobPost {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@ManyToOne()
	@JoinColumn(name="job_title_id",referencedColumnName = "id")
	private JobTitle jobtitle;
	
	
	@Column(name="job_description")
	private String description;
	
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;

	
	@Column(name="maxSalary")
	private int maxSalary;
	
	
	@Column(name="minSalary")
	private int minSalary;

	
	@Column(name="open_position_count")
	private int openPositionCount;
	
	
	@Column(name="applicationdeadline")
	private Date applicationdeadline; 
	
	@Column(name ="isActive")
	private boolean isActive;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	

}
