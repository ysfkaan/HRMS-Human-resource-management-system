package kodlamaio.hrms.entities.concretes.main;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import kodlamaio.hrms.entities.concretes.post.JobPost;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Entity
@Table(name="employers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobpost"})
public class Employer extends User   {
	
	
	
	
	@Id
	@Column(name="id")
	private int id;
	
	
	@Column(name="company_name")
	private  String companyName;
	
	
	@Column(name="web_address")
	private String webAddress;
	
	
	@OneToMany(mappedBy = "employer")
	private List<JobPost> jobpost;
	
	
	
	
}
