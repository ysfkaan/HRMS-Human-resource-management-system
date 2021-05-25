package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class Employer  extends User {
	
	
	
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private  String companyName;
	
	
	@Column(name="web_address")
	private String webAddress;
	
	
}
