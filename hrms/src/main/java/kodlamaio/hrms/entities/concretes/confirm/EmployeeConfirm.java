package kodlamaio.hrms.entities.concretes.confirm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="employee_confirms")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeConfirm {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	
	@Column(name="employee_id")
	private int employeeId;

	
	@Column(name="is_confirmed")
	private boolean isConfirmed;

}
