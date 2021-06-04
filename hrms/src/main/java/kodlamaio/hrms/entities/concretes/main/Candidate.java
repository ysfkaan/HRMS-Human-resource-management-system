package kodlamaio.hrms.entities.concretes.main;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;





@Data
@Entity
@Table(name="candidates")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Candidate extends User {
	
	
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="First_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identification_number")
	private String identificationNumber;
	
	@Column(name="birth_date")
	private Date birthDate;
	

	



	
	

}
