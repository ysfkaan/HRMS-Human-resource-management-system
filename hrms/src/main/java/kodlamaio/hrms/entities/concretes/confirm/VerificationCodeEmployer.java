package kodlamaio.hrms.entities.concretes.confirm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="verification_codes_employers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VerificationCodeEmployer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="employer_id")
	private int employerId;

}
