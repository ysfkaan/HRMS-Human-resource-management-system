package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;  

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Table(name="users")

public class Users {
	
	@Id
	@GeneratedValue()
	@Getter
	@Setter
	@Column(name="id")
	private int id;
	@Column(name="email")
	@Getter
	@Setter
	private String email;
	@Column(name="password")
	@Getter
	@Setter
	private String password;
	
	
	
	public Users(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
}
